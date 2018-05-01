package dao;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface InfoMapper{

    @Select("SELECT * FROM info")
    List<Info> findAll();

    @Select("SELECT * FROM info WHERE id = #{id}")
    Info getById(int id);

    @Update("update info set name=#{name}, email=#{email} where id=#{id}")
    void edit(Info info);

    @Delete("DELETE FROM info WHERE id = #{id}")
    void delete(int id);

    @Insert("INSERT INTO info (name, email) VALUES (#{name}, #{email})")
    void save(Info info);
}