package piao888.top.meijv;

public enum AAA {
    ID("id",1),;
    private String id;
    private int values;

    AAA(String id, int values) {
        this.id = id;
        this.values = values;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getValues() {
        return values;
    }

    public void setValues(int values) {
        this.values = values;
    }
}
