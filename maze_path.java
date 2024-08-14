import java.util.ArrayList;

public class maze_path {
    public static void main(String[] args) {
//        path("", 3, 4);
//        System.out.println(path1("", 3, 3));
//        System.out.println(path2("",3,3));
        boolean[][] arr={
                {true,true,true},
                {true,false,true},
                {true,true,true}
        };
        pathrock("",arr,0,0);

    }

    public static void path(String a, int r, int c) {
        if (r == 1 && c == 1) {
            System.out.println(a);
            return;
        }
        if (r > 1) {
            path(a + 'D', r - 1, c);
        }
        if (c > 1) {
            path(a + 'R', r, c - 1);
        }
    }

    public static ArrayList<String> path1(String a, int r, int c) {
        if (r == 1 && c == 1) {
            ArrayList<String> list = new ArrayList<>();
            list.add(a);
            return list;

        }
        ArrayList<String> ans = new ArrayList<>();
        if (r > 1) {
            ans.addAll(path1(a + 'D', r - 1, c));
        }
        if (c > 1) {
            ans.addAll(path1(a + 'R', r, c - 1));
        }
        return ans;
    }

    public static ArrayList<String> path2(String a, int r, int c) {
        if (r == 1 && c == 1) {
            ArrayList<String> list = new ArrayList<>();
            list.add(a);
            return list;

        }
        ArrayList<String> ans = new ArrayList<>();
        if (r > 1 && c > 1) {
            ans.addAll(path2(a + 'D', r - 1, c - 1));}
            if (r > 1) {
                ans.addAll(path2(a + 'v', r - 1, c));
            }
            if (c > 1) {
                ans.addAll(path2(a + 'h', r, c - 1));
            }


        return ans;
    }
    public static void pathrock(String a,boolean[][] maze, int r, int c) {
        if (r == maze.length- 1 && c == maze[0].length - 1) {
            System.out.println(a);
            return;
        }
        if (!maze[r][c]) {
            return;

        }
        if (r < maze.length - 1) {
            pathrock(a + 'D', maze, r +1, c);
        }
        if (c < maze[0].length-1) {
            pathrock(a + 'R', maze, r, c +1);
        }
    }
}
