package org.jiji.trapp.dto;

import org.codehaus.jackson.map.annotate.JsonRootName;

/**
 * @author J van der Griendt
 * 
 */
@JsonRootName("user")
public class UserDto extends AbstractJsonDto
{

    private static final long serialVersionUID = -2145471531057856497L;

    private String name;
    private String surnamePrefix;
    private String surname;
    private String email;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurnamePrefix() {
        return surnamePrefix;
    }

    public void setSurnamePrefix(String surnamePrefix) {
        this.surnamePrefix = surnamePrefix;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

}
