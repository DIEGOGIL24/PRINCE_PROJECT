package co.edu.uptc.PRINCE_PROJECT_2V.Exeptions;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Mensaje {
    private int code;
    private String message;
    private int codeHttp;

}
