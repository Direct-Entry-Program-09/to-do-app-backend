package lk.ijse.dep9.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDTO implements Serializable {
    @NotNull(message = "Username cannot be empty")
    @Pattern(regexp = "[a-zA-Z0-9]+",message = "Invalid username")
    private String userName;
    @NotNull(message = "password cannot be empty")
    @Min(value = 8,message = "password length should be more than 8")
    private String passWord;
    @NotNull(message = "Full name cannot be empty")
    @Pattern(regexp = "[a-zA-Z ]+",message = "Invalid name")
    private String fullName;
}
