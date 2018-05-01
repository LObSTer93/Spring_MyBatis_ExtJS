package dao;

import lombok.*;

/**
 * Данные в БД
 */
@AllArgsConstructor
public class Info {

    @Getter
    @Setter
    private Integer id;

    @Getter
    @Setter
    private String name;

    @Getter
    @Setter
    private String email;
}