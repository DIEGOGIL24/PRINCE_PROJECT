package co.edu.uptc.PRINCE_PROJECT_2V.Exeptions;



import org.springframework.http.HttpStatus;

public enum TypeMessage {
    NOT_FOUND(HttpStatus.BAD_REQUEST.value(), "Not Found", 404),
    NOT_SAVED(HttpStatus.BAD_REQUEST.value(), "Not Saved", 410),
    INFORMATION_INCOMPLETE(HttpStatus.BAD_REQUEST.value(), "Infomration Incomplete", 430),
    NOT_FOUND_FILE(HttpStatus.BAD_REQUEST.value(), "Not Found file", 420),
    SAVE(HttpStatus.OK.value(), "Saved", 200),
    ELEMENT_ALRREADY_EXIST(HttpStatus.BAD_REQUEST.value(), "This elemente already Exists", 409),
    EMPTY_LIST(HttpStatus.BAD_REQUEST.value(), "List is empty", 800);

    public final String message;
    public final int code;
    public final int codeHttp;

    private TypeMessage(int codeHttp, String message, int code) {
        {
            this.message = message;
            this.code = code;
            this.codeHttp = codeHttp;
        }

    }

}
