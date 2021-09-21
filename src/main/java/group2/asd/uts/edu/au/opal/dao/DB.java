package group2.asd.uts.edu.au.opal.dao;

import lombok.Getter;

@Getter
public class DB {
    protected String url;
    protected String databaseName;

    public DB() {
        url = "mongodb+srv://opal:OPALCARDMANAGER@asd.axojh.mongodb.net/myFirstDatabase?retryWrites=true&w=majority";
        databaseName = "dev";
    }
}
