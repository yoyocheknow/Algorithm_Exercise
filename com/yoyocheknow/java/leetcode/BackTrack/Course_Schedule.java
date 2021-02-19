package leetcode.BackTrack;

import java.util.*;

/**
 * 课程表
 * There are a total of numCourses courses you have to take, labeled from 0 to numCourses - 1. You are given an array
 * prerequisites where prerequisites[i] = [ai, bi] indicates that you must take course bi first if you want to take course ai.
 *
 * For example, the pair [0, 1], indicates that to take course 0 you have to first take course 1.
 * Return true if you can finish all courses. Otherwise, return false.
 * @author zhihua on 2021/2/18
 */
public class Course_Schedule {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
	/*
			Input: numCourses = 4, prerequisites = [[1,0],[3,2],[3,1]]

				classes: 0, 1, 2, 3
				graph:
						(0) -> (1) -> (3) <- (2)

							(0) -> (1) -> (3) good
								   (2) -> (3) good
			Output: true

			Input: numCourses = 2, prerequisites = [[1,0],[0,1]]

				classes: 0, 1
				graph:
						(0) ->  <- (1)
						(0) -> (1) -> (0) bad
			Output: false

			ALGORITHM
				STEP 1: if numCourses == 1 return true
				STEP 2: create an adjacency list representing a graph of classes to prerequisites
				STEP 3: create a set to record visited classes
				STEP 4: call depth-first search to verify all class can be completed
						-> return false if not
				STEP 5: return true
		*/
        if(numCourses <= 1) {
            return true;
        }

        Map<Integer, List<Integer>> courses = new HashMap<>();
        for(int[] pair: prerequisites) {

            int mustTakeBeforeA = pair[0];
            int classA = pair[1];

            if(!courses.containsKey(classA)) {
                courses.put(classA, new ArrayList<Integer>());
            }
            courses.get(classA).add(mustTakeBeforeA);
        }

        Set<Integer> visited = new HashSet<>();
        Map<Integer, Boolean> memo = new HashMap<>();

        for(int c: courses.keySet()) {
            if(!dfs(c, courses, visited, memo)) {
                return false;
            }
        }

        return true;
    }

    public boolean dfs(int currentClass, Map<Integer, List<Integer>> courses, Set<Integer> visited, Map<Integer, Boolean> memo) {

		/*
			ALGORITHM
				BASE CASE: if the current class has been visited return false
				BASE CASE: if the current class is not in the courses keySet return true
				BASE CASE: if memo table contains the class return the search result

				STEP 1: mark the class as visited
				STEP 2: get the list of prerequisites
				STEP 3: loop through the prerequisites
					STEP 4: call dfs
							-> if you are able to complete a class return false
							-> memorize each class searched on

		*/
        if(memo.containsKey(currentClass)) {
            return memo.get(currentClass);
        }
        if(visited.contains(currentClass)){
            return false;
        }

        if(!courses.containsKey(currentClass)) {
            return true;
        }

        visited.add(currentClass);
        List<Integer> requiredClasses = courses.get(currentClass);

        for(int requiredClass: requiredClasses) {
            if(dfs(requiredClass, courses, visited, memo) == false) {
                return false;
            }
            memo.put(requiredClass, true);
        }

        visited.remove(currentClass);
        return true;
    }

    public static void main(String[]args){
        System.out.println(new Course_Schedule().canFinish(4,new int[][]{{1,0},{3,2},{3,1}}));
    }
}