package org.jiji.trapp.queries;

public interface UserQueries
{

    String QNAME_GEBRUIKER_PER_ABONNEE_BY_GEBRUIKER_AND_ABONNEE = "GebruikerPerAbonnee.byGebruikerAndAbonnee";
    String QUERY_GEBRUIKER_PER_ABONNEE_BY_GEBRUIKER_AND_ABONNEE = "from GebruikerPerAbonnee gpa where gpa.gebruiker = :gebruiker and gpa.abonnee = :abonnee";
}
