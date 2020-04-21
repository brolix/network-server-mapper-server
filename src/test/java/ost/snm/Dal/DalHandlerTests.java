package ost.snm.Dal;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import ost.snm.contracts.DalHandler;
import ost.snm.model.Segment;

@SpringBootTest
public class DalHandlerTests {

    @Autowired
    private DalHandler dalHandler;

    @AfterEach
    public void TearDown(){
        dalHandler.deleteAll();
    }

    @Test
    public void TestAddSingleSegmentWithoutServers()
    {
        //given a clean database


        //when we try to add a segment to the database
//        Segment segment = new Segment("192.168.1","Test",)

        //then the segment is added (got id)
        //and the database has one value
    }

}
