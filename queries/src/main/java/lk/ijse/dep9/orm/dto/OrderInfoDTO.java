package lk.ijse.dep9.orm.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data @AllArgsConstructor @NoArgsConstructor
public class OrderInfoDTO implements Serializable {
    private String id;
    private String name;
    private String orderId;
}
