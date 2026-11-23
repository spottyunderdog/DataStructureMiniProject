package moduleA;

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

    public int getId() {
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

    public boolean equals(Resource resource) {
        return (this.id == resource.getId() || this.name.equals(resource.getName()) );
    }
    @Override
    public String toString() {
        return String.format("Name: %s | ID %d | Category: %s | Building: %s | Available: %b | Popularity: %d",
                 name, id, category, building, availability, popularityScore);
    }

}
