public int[] findOrder(int numCourses, int[][] prerequisites) {
        int[] numOfPreReq = new int[numCourses];
        List[] preReq = new ArrayList[numCourses];
        Queue<Integer> q = new LinkedList<Integer>();
        int[] order = new int[numCourses];
        
        for (int i = 0; i<numOfPreReq.length; i++) {
            numOfPreReq[i] = 0;
        }
        for (int i = 0; i<prerequisites.length; i++) {
            numOfPreReq[prerequisites[i][0]]++;
            if (preReq[prerequisites[i][1]] == null) {
                preReq[prerequisites[i][1]] = new ArrayList<Integer>();
            }
            preReq[prerequisites[i][1]].add(prerequisites[i][0]);
        }
        
        for (int i = 0; i<numOfPreReq.length; i++) {
            if (numOfPreReq[i] == 0) {
                q.add(i);
            }
        }
        
        int index = 0;
        while (!q.isEmpty()) {
            int course = q.poll();
            order[index++] = course;
            
            if (preReq[course] != null) {
                List<Integer> listOfCourse= preReq[course];
                for (Integer advCourse : listOfCourse) {
                    numOfPreReq[advCourse]--;
                    if (numOfPreReq[advCourse] == 0) {
                        q.add(advCourse);
                    }
                }
            }
        }
        
        if (index == numCourses) {
            return order;
        }
        
        return new int[] {};
    }
