package pl.edu.bogdan.training.patterns.nullobjectpattern;

public class Subject {
	private final String name;
	private final int difficultyLevel;
	public Subject(String name, int difficultyLevel) {
		super();
		this.name = name;
		this.difficultyLevel = difficultyLevel;
	}
	public String getName() {
		return name;
	}
	public int getDifficultyLevel() {
		return difficultyLevel;
	}
}
