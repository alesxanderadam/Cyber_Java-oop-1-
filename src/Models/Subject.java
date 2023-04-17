package Models;

public class Subject {
        private String subjectName;
        private float score;

        public Subject(String subjectName) {
            this.subjectName = subjectName;
        }

        public String getSubjectName() {
            return subjectName;
        }

        public void setSubjectName(String subjectName) {
            this.subjectName = subjectName;
        }

        public float getScore() {
            return score;
        }

        public void setScore(float score) {
            this.score = score;
        }
}
