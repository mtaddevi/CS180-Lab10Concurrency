import java.util.List;

/**
 * This class is responsible for the actual grading of each submission. It can
 * be instantiated with the default constructor as follows:
 * 
 * Grader grader = new Grader();
 */
public class Grader {

	/**
	 * This method should grade the submission as follows:
	 * 
	 * - Compile the submission. - If the compilation is not successful, assign
	 * a score of zero to the submission. - Otherwise, run the submission with
	 * each test case's input in the assignment corresponding to the submission.
	 * - Sum the point values of each passing test case and assign the sum as
	 * the submission's grade. - A passing test case is defined as a test case
	 * where the output produced by the submission is **exactly identical** to
	 * the test case's expected output.
	 */
	public void gradeSubmission(Submission submission) {

		//submission.compile();
		Assignment toTest = submission.getAssignment();
	
		int grade = 0;
		
		//if (submission.compile() == false) {
			submission.assignGrade(0);
		//}
		 if(submission.compile() == true){
		for (TestCase tc : toTest.getTests()) {
			submission.runWithInput(tc.getInput());
			//submission.getGrade();
			if (tc.getExpectedOutput().equals(
					submission.runWithInput(tc.getInput()))) {
				grade = grade + tc.getPoints();
				submission.assignGrade(grade);
			}

			}
		}
	}

}
