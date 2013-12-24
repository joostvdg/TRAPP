package org.jiji.trapp.dto;


/**
 * @author J van der Griendt
 * 
 */
public class UserRoleDto extends AbstractJsonDto
{
    /**
     * 
     */
    private static final long serialVersionUID = 1L;

    private String code;

    private String description;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

}
