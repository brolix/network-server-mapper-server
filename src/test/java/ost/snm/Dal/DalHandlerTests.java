package ost.snm.Dal;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import ost.snm.contracts.DalHandler;
import ost.snm.model.Segment;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static org.assertj.core.api.Assertions.*;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@ActiveProfiles(profiles = {"test"})
public class DalHandlerTests {

    @Autowired
    private DalHandler dalHandler;

    @AfterEach
    public void tearDown() {
        dalHandler.deleteAll();
    }

    @Test
    public void testAddSingleSegmentWithoutServers() {
        //given a clean database
        assertEquals(0, dalHandler.getAllSegments().size());

        //when we try to add a segment to the database
        Segment segment = new Segment("192.168.1", "Test", null, null);

        Segment returnedSeg = dalHandler.createSegment(segment);

        //then the segment is added (got id)
        //and the database has one value
        assertAll(() -> assertNotNull(returnedSeg.getId()),
                () -> assertNotEquals(0, dalHandler.getAllSegments().size()));
    }

    @Test
    public void testAddMultipleSegmentsWithoutServers() {
        //given a clean database
        assertEquals(0, dalHandler.getAllSegments().size());

        //when we add multiple segments
        List<Segment> segments = IntStream.range(1, 4)
                .mapToObj(i -> new Segment("192.168." + i, "Test" + i, null, null))
                .collect(Collectors.toList());

        assertNull(segments.get(0).getId());

        dalHandler.createSegments(segments);

        //then the database is updated with all servers
        //and local servers have id
        assertAll(
                () -> assertEquals(segments.size(), dalHandler.getAllSegments().size()),
                () -> segments.forEach(s -> assertNotNull(s.getId()))
        );
    }

    @Test
    public void testAddAnExistingSegmentWithTheSameIdAndCheckDatabaseSizeStillEqualsOne() {
        //Given a database with single segment
        Segment segment = new Segment("192.168.1", "Test", null, null);
        Segment returnedSeg = dalHandler.createSegment(segment);

        //when we try to add a new segment with the same ID(!)
        Segment newReturnedSeg = dalHandler.createSegment(returnedSeg);

        //Then the database updates the same segment object
        //and database size is still 1
        assertAll(
                () -> assertEquals(1, dalHandler.getAllSegments().size()),
                () -> assertEquals(returnedSeg.getDesc(), newReturnedSeg.getDesc())
        );
    }

    @Test
    public void testTryAddingNullSegmentObjectToTheDatabaseAndItFails() {
        //Given an empty database
        assertEquals(0, dalHandler.getAllSegments().size());

        //When we try to add a null Segment Object to the database
        //Then an IllegalArgumentException is thrown
        assertThrows(IllegalArgumentException.class, () -> dalHandler.createSegment(null));
    }

    @Test
    public void testTryToAddSomeSegmentWithOneSegmentBeingANullObjectAndFailsAll() {
        //Given an empty database
        assertEquals(0, dalHandler.getAllSegments().size());

        //When we try to add a some segments and a null Segment Object to the database
        List<Segment> segments = IntStream.range(1, 4)
                .mapToObj(i -> new Segment("192.168." + i, "Test" + i, null, null))
                .collect(Collectors.toList());
        segments.add(null);

        //Then an IllegalArgumentException is thrown
        // and the database stays empty
        assertAll(
                () -> assertThrows(IllegalArgumentException.class, () -> dalHandler.createSegments(segments)),
                () -> assertEquals(0, dalHandler.getAllSegments().size())

        );
    }

    @Test
    public void testGetAllSegmentsOnADatabaseWithOneSegment() {
        //Given a database with single segment
        Segment segment = new Segment("192.168.1", "Test", null, null);
        Segment expectedSegment = dalHandler.createSegment(segment);

        //When we request all segments object from the database
        List<Segment> segments = (ArrayList<Segment>) dalHandler.getAllSegments();

        //Then we get the object that was added
        //and the database size is 1
        assertAll(
                () -> assertEquals(1, segments.size()),
                () -> assertEquals(expectedSegment, segments.get(0))
        );
    }

    @Test
    public void testGetAllSegmentWith100SegmentsInDatabase() {
        //Given a database with 100 elements
        List<Segment> segments = IntStream.range(1, 101)
                .mapToObj(i -> new Segment("192.168." + i, "Test" + i, null, null))
                .collect(Collectors.toList());
        dalHandler.createSegments(segments);
        assertThat(dalHandler.getAllSegments())
                .isNotNull()
                .hasSize(segments.size());

        //When we request all segments objects from the database
        List<Segment> results = (List<Segment>) dalHandler.getAllSegments();

        //Then we get the same object as the local ones
        //and we get 100 results
        assertAll(
                () -> assertEquals(segments.size(), results.size()),
                () -> assertArrayEquals(segments.toArray(), results.toArray())
        );
    }

    @Test
    public void testDeleteOneSegmentFromTheDatabaseContaining100Records() {
        //Given a database with 100 elements
        List<Segment> segments = IntStream.range(1, 101)
                .mapToObj(i -> new Segment("192.168." + i, "Test" + i, null, null))
                .collect(Collectors.toList());
        dalHandler.createSegments(segments);

        //When we try to remove segment 192.168.23
        Segment removedSegment = segments.get(22);
        assertEquals("192.168.23", removedSegment.getSubnetAddr());

        dalHandler.deleteSegment(removedSegment);

        //Then the segment is removed from the database
        //and the database contains only 99 records
        assertAll(
                () -> assertThat(dalHandler.getAllSegments().size())
                        .isEqualTo(segments.size() - 1),
                () -> assertThat(dalHandler.getAllSegments())
                        .doesNotContain(removedSegment)
        );
    }

    @Test
    public void testTryToDeleteNullSegmentObjectAndFail(){
        //Given a database with single segment
        Segment segment = new Segment("192.168.1", "Test", null, null);
        Segment expectedSegment = dalHandler.createSegment(segment);

        //When we try to delete null object
        //Then an Exception is thrown
        assertThatThrownBy(()->dalHandler.deleteSegment(null));
    }

}
