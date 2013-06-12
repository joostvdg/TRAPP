package org.jiji.trapp.dto;

import java.io.Serializable;

public class UserDto extends AbstractDto implements Serializable {

    /**
     * 
     */
    private static final long serialVersionUID = -2145471531057856497L;

    private String name;

    private String preposition;

    private String surname;

    private String email;

    /**
     * @return the name
     */
    public final String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public final void setName(String name) {
        this.name = name;
    }

    /**
     * @return the preposition
     */
    public final String getPreposition() {
        return preposition;
    }

    /**
     * @param preposition the preposition to set
     */
    public final void setPreposition(String preposition) {
        this.preposition = preposition;
    }

    /**
     * @return the surname
     */
    public final String getSurname() {
        return surname;
    }

    /**
     * @param surname the surname to set
     */
    public final void setSurname(String surname) {
        this.surname = surname;
    }

    /**
     * @return the email
     */
    public final String getEmail() {
        return email;
    }

    /**
     * @param email the email to set
     */
    public final void setEmail(String email) {
        this.email = email;
    }

}
