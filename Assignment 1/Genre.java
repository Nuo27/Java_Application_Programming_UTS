
public class Genre {
	private String name;
			// write your solution here
	public Genre(String name) {
        this.name = name;
    }
    public boolean hasType(String name) {
        return this.name.equals(name);
    }
    @Override
    public String toString() {
        return name;
    }
}
