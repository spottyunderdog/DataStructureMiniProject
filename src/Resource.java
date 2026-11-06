public class Resource {
    private final int id;
    private final String name;
    private final String category;
    private final String building;
    private boolean availability;
    private final int popularityScore;


    public Resource(int resourceId, String resourceName, String resourceCat,
                    String building, boolean isAvailable, int popularity) {
        this.id = resourceId;
        this.name = resourceName;
        this.category = resourceCat;
        this.building = building;
        this.availability = isAvailable;
        this.popularityScore = popularity;
    }

    int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getCatagory() {
        return category;
    }

    public String getBuilding() {
        return building;
    }

    public void setAvailability(boolean status) {
        availability = status;
    }

    public boolean getAvailability() {
        return availability;
    }

    public int getPopularityScore() {
        return popularityScore;
    }
}
