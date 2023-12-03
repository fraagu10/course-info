package io.prototype.courseinfo.cli;

import io.prototype.courseinfo.cli.services.CourseRetrieverService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CourseRetriever {
    private static final Logger LOG = LoggerFactory.getLogger(CourseRetriever.class);

    public static void main(String... args) {
        LOG.info("Course Retriever initiated...");

        if(args.length == 0) {
            LOG.warn("Please provide an author name as first argument.");
            return;
        }

        try {
            retrieveCourses(args[0]);
        } catch (Exception e) {
            LOG.error("Unexpected Error", e);
        }

    }


    private static void retrieveCourses(String authorName) {
        LOG.info("Retrieving course for author '{}'", authorName);
        CourseRetrieverService courseRetrieverService = new CourseRetrieverService();

        String retrievedCourses = courseRetrieverService.getCoursesFor(authorName);
        LOG.info("Retrieved the following courses: {}", retrievedCourses);
    }
}
