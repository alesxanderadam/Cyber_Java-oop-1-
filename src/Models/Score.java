package Models;

import java.util.Scanner;

public class Score {
    private Subject subject;
    private float score;
    private float totalScore;
    private int numOfSubjects;
    private String rank;

    public Score(Subject subject, float score) {
        this.subject = subject;
        this.score = score;
        this.totalScore = score;
        this.numOfSubjects = 1;
    }
    public Score(){}
    public float getScore() {
        return score;
    }

    public void setScore(float score) {
        this.score = score;
    }

    public String getRank() {
        return rank;
    }

    public Subject getSubject() {
        return subject;
    }

    public void setSubject(Subject subject) {
        this.subject = subject;
    }

    public void setRank(String rank) {
        this.rank = rank;
    }
    public void addScore(float score) {
        this.totalScore += score;
        this.numOfSubjects++;
    }

    public static Score inputScores(Scanner scanner) {
        System.out.print("Enter subject name: ");
        String subjectName = scanner.nextLine();

        System.out.print("Enter point subject: ");
        float score = Float.parseFloat(scanner.nextLine());

        Subject subject = new Subject(subjectName);
        Score subjectScore = new Score(subject, score);

        return subjectScore;
    }

    public void calculateClassification(float avg) {
        if (avg >= 8.5) setRank("Very good");
        else if (avg >= 7.0 && avg < 8.5) {
            setRank("Good");
        } else if (avg >= 5.0 && avg < 7.0) {
            setRank("Not bad");
        } else {
            setRank("Bad");
        }
    }
}
