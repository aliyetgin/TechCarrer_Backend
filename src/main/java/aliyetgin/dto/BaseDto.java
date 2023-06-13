package aliyetgin.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

// Lombok
@Data

abstract public class BaseDto {
    private Long id;
    private Date createdDate;

    // Constructor without parameters
    public BaseDto() { this.createdDate=new Date(System.currentTimeMillis());} // 10 August 1990}

    public BaseDto(Long id, Date createdDate) {
        this.id = id;
        this.createdDate = createdDate;
    }
}
