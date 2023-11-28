package io.prototype.courseinfo.cli;

public class CourseRetriever {

    public static void main(String... args) {
        System.out.println("Course Retriever initiated...");

        if(args.length == 0) {
            System.out.println("Please provide an author name as first argument.");
            return;
        }

        try {
            retrieveCourses(args[0]);
        } catch (Exception e) {
            System.out.println("Unexpected Error.");
            e.printStackTrace();
        }

    }


    private static void retrieveCourses(String authorName) {
        System.out.println("Retrieving course for author " + authorName);
    }
}
