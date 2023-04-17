package Models;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Student implements Comparable<Student> {
    private String student_id;
    private String student_name;
    private Boolean gender;
    private Date birth_of_date;
    private List<Score> scores;

    public Student() {}

    public Student(String student_id, String student_name, Boolean gender, Date birth_of_date) {
        this.student_id = student_id;
        this.student_name = student_name;
        this.gender = gender;
        this.birth_of_date = birth_of_date;
        this.scores = new ArrayList<>();
    }

    public String getStudent_id() {
        return student_id;
    }

    public void setStudent_id(String student_id) {
        this.student_id = student_id;
    }

    public String getStudent_name() {
        return student_name;
    }

    public void setStudent_name(String student_name) {
        this.student_name = student_name;
    }

    public Boolean getGender() {
        return gender;
    }

    public void setGender(Boolean gender) {
        this.gender = gender;
    }

    public Date getBirth_of_date() {
        return birth_of_date;
    }

    public void setBirth_of_date(Date birth_of_date) {
        this.birth_of_date = birth_of_date;
    }

    public List<Score> getScores() {
        return scores;
    }

    public void addScore(Score score) {
        scores.add(score);
    }
    public List<Score> getScoresBySubject(String subjectName) {
        List<Score> result = new ArrayList<>();
        for (Score score : scores) {
            if (score.getSubject().getSubjectName().equals(subjectName)) {
                result.add(score);
            }
        }
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        Score avg = new Score();
        float totalScore = 0;
        int count = 0;
        for (Score score : scores) {
            totalScore += score.getScore();
            count++;
        }
        float averageScore = count > 0 ? totalScore / count : 0;
        sb.append("Student:\n" + " { ")
                .append("Student id='").append(student_id).append('\'')
                .append(", Student name=").append(student_name).append('\'')
                .append(", Gender=").append(gender)
                .append(", Birth_of_date=" ).append(birth_of_date + ", \n");

        sb.append(" Scores: [ ");
        for (Score score : scores) {
            sb.append("{ Subject name=").append(score.getSubject().getSubjectName())
                    .append(", Score=").append(score.getScore())
                    .append(" }, ");
        }
        if (scores.size() > 0) {
            sb.delete(sb.length() - 2, sb.length());
        }
        sb.append(" ], \n");
        sb.append("AverageScore: ").append(averageScore + ", ");
        sb.append(" Rank: ");
        avg.calculateClassification(averageScore);
            sb.append(avg.getRank() + "\n");
        sb.append(" }");
        return sb.toString();
    }

    @Override
    public int compareTo(Student o) {
      // use interface Compareable to check id student is exists ?
        return this.student_id.compareTo(o.student_id);
    }
}
