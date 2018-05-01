package dao;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = DBConfig.class)
@ActiveProfiles("test")
public class InfoMapperTest {

    @Autowired
    private InfoMapper infoMapper;

    @Test
    public void getByIdTest(){
        Info info = infoMapper.getById(1);
        assertNull(info);

        info = new Info(1, "name", "email");
        infoMapper.save(info);

        info = infoMapper.getById(1);
        assertNotNull(info);
    }

    @Test
    public void editTest(){
        Info info = new Info(1, "name", "email");
        infoMapper.save(info);

        info = infoMapper.getById(1);
        assertEquals(info.getName(), "name");
        assertEquals(info.getEmail(), "email");

        info.setName("name1");
        info.setEmail("email1");

        infoMapper.edit(info);

        info = infoMapper.getById(1);
        assertEquals(info.getName(), "name1");
        assertEquals(info.getEmail(), "email1");
    }
}