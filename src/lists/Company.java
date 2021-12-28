package lists;

/* две SLL листи, од едната да се најде најмладиот член во таа листа според година која се
внесува на влез, да се вметне во средина на другата листа и да се избрише од старата

input:
60
90
16599 56
13317 26
17951 30
16526 20
14635 41
17959 27
13200 34
18948 43
10239 27
11615 60
16616 35
16075 21
11290 45
11384 25
12897 53
15564 29
19227 41
11390 62
13203 57
15070 59
12493 39
15029 30
11687 47
10462 52
13482 59
12739 26
19334 27
19133 40
11837 39
14160 24
11831 52
15708 23
17708 22
12164 59
16420 49
11589 32
19837 39
18597 55
18248 32
12836 56
11883 36
16666 33
12112 29
10573 25
11475 64
10047 23
10228 26
13580 54
15213 39
17982 20
15332 32
11742 40
16411 31
12515 20
12170 46
12166 26
17396 51
18804 21
13212 31
16553 34
15420 22
14856 31
16021 35
13863 34
13860 29
10257 55
17632 37
19686 31
18561 50
13334 49
17293 53
19680 57
14055 39
18748 50
16861 36
10927 63
12947 44
12026 20
19400 22
15208 61
12674 49
14204 30
10455 43
11445 57
16402 39
18910 52
15660 36
11593 26
12735 31
16575 38
11910 43
10552 54
10406 33
12624 31
16807 33
13657 23
14341 22
12306 29
13235 30
14331 47
11189 33
12911 32
18590 30
13900 28
15080 21
14591 55
11971 60
12695 42
14353 31
19238 29
11809 34
19300 33
18201 28
14107 34
13506 20
14082 30
17690 21
10225 24
12438 46
15900 37
16453 23
10149 32
15280 54
16861 59
18492 22
13144 55
12426 48
13994 53
16684 42
10486 53
12541 59
18558 47
19579 38
12552 22
12559 51
10675 39
19991 36
13614 36
16465 23
17335 33
14051 22
11384 51
16990 30
12400 59
18686 38
10143 56
17812 54
19472 45
13280 64
17915 20

output:
16599 13317 17951 16526 14635 17959 13200 18948 10239 11615 16616 16075 11290 11384 12897 15564 19227 11390 13203 15070 12493 15029 11687 10462 13482 12739 19334 19133 11837 14160 17915 11831 15708 17708 12164 16420 11589 19837 18597 18248 12836 11883 16666 12112 10573 11475 10047 10228 13580 15213 17982 15332 11742 16411 12515 12170 12166 17396 18804 13212 16553
15420 14856 16021 13863 13860 10257 17632 19686 18561 13334 17293 19680 14055 18748 16861 10927 12947 12026 19400 15208 12674 14204 10455 11445 16402 18910 15660 11593 12735 16575 11910 10552 10406 12624 16807 13657 14341 12306 13235 14331 11189 12911 18590 13900 15080 14591 11971 12695 14353 19238 11809 19300 18201 14107 13506 14082 17690 10225 12438 15900 16453 10149 15280 16861 18492 13144 12426 13994 16684 10486 12541 18558 19579 12552 12559 10675 19991 13614 16465 17335 14051 11384 16990 12400 18686 10143 17812 19472 13280

 */




import java.util.Scanner;

class SLLNode3 {
    int id;
    int age;
    SLLNode3 succ;

    public SLLNode3(int id, int age, SLLNode3 succ) {
        this.id = id;
        this.age = age;
        this.succ = succ;
    }

    @Override
    public String toString() {
        return String.valueOf(id);
    }
}

class SLL3 {
    SLLNode3 first;

    public SLL3() {
        this.first = null;
    }

    public void insertFirst(int id, int age) {
        SLLNode3 insert = new SLLNode3(id, age, first);
        first = insert;
    }

    public void insertAfter(int id, int age, SLLNode3 after) {
        if (after != null) {
            SLLNode3 insert = new SLLNode3(id, age, after.succ);
            after.succ = insert;
        } else {
            System.out.println("NULL NODE!");
        }
    }

    public void insertBefore(int id, int age, SLLNode3 before) {
        if (first != null) {
            SLLNode3 tmp = first;
            if (first == before) {
                this.insertFirst(id, age);
                return;
            }
            while (tmp.succ != before)
                tmp = tmp.succ;
            if (tmp.succ == before) {
                SLLNode3 insert = new SLLNode3(id, age, before);
                tmp.succ = insert;
            } else {
                System.out.println("NULL NODE!");
            }
        } else {
            System.out.println("EMPTY LIST!");
        }
    }

    public void insertLast(int id, int age) {
        if (first != null) {
            SLLNode3 tmp = first;
            while (tmp.succ != null)
                tmp = tmp.succ;
            SLLNode3 insert = new SLLNode3(id, age, null);
            tmp.succ = insert;
        } else {
            insertFirst(id, age);
        }
    }

    public SLLNode3 deleteFirst() {
        if (first != null) {
            SLLNode3 tmp = first;
            first = first.succ;
            return tmp;
        } else {
            System.out.println("EMPTY LIST!");
            return null;
        }
    }

    public SLLNode3 delete(SLLNode3 node) {
        if (first != null) {
            SLLNode3 tmp = first;
            if (first == node) {
                return this.deleteFirst();
            }
            while (tmp.succ != node && tmp.succ.succ != null)
                tmp = tmp.succ;
            if (tmp.succ == node) {
                tmp.succ = tmp.succ.succ;
                return node;
            } else {
                System.out.println("NODE WAS NOT FOUND!");
                return null;
            }
        } else {
            System.out.println("EMPTY LIST!");
            return null;
        }
    }

    public int length() {
        int ret;
        if (first != null) {
            SLLNode3 tmp = first;
            ret = 1;
            while (tmp.succ != null) {
                tmp = tmp.succ;
                ret++;
            }
            return ret;
        } else
            return 0;
    }

    @Override
    public String toString() {
        StringBuilder ret = new StringBuilder();
        if (first != null) {
            SLLNode3 tmp = first;
            ret.append(tmp).append(" ");
            while (tmp.succ != null) {
                tmp = tmp.succ;
                ret.append(tmp).append(" ");
            }
        } else
            ret = new StringBuilder("NO ELEMENTS");
        return ret.toString();
    }
}

public class Company {
    public static void alterTeams(SLL3 devTeam, SLL3 qaTeam) {
        //todo: enter code here

        //две SLL листи, од едната да се најде најмладиот член во таа листа според година која се
        //внесува на влез, да се вметне во средина на другата листа и да се избрише од старата

        SLLNode3 qaNajmlad = qaTeam.first;
        SLLNode3 temp = qaTeam.first;

        while (temp != null) {
            if (qaNajmlad.age >= temp.age) {
                qaNajmlad = temp;
            }
            temp = temp.succ;
        }
        SLLNode3 td = devTeam.first;
        int c = 0;

        while (td != null) {
            c++;
            td = td.succ;
        }
        td = devTeam.first;
        for (int i = 0; i < c / 2; i++) {
            td = td.succ;
        }
        if (c % 2 == 0) {
            devTeam.insertBefore(qaNajmlad.id, qaNajmlad.age, td);
            qaTeam.delete(qaNajmlad);
        } else {
            devTeam.insertAfter(qaNajmlad.id, qaNajmlad.age, td);
            qaTeam.delete(qaNajmlad);
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int devNum = Integer.parseInt(scanner.nextLine());
        int qaNum = Integer.parseInt(scanner.nextLine());
        SLL3 devTeam = new SLL3();
        SLL3 qaTeam = new SLL3();

        for (int i = 0; i < devNum; i++) {
            String line = scanner.nextLine();
            String[] parts = line.split("\\s+");
            //todo: enter code here
            int a = Integer.parseInt(parts[0]);
            int b = Integer.parseInt(parts[1]);
            devTeam.insertLast(a, b);
        }

        for (int i = 0; i < qaNum; i++) {
            String line = scanner.nextLine();
            String[] parts = line.split("\\s+");
            //todo: enter code here
            int a = Integer.parseInt(parts[0]);
            int b = Integer.parseInt(parts[1]);
            qaTeam.insertLast(a, b);
        }

        alterTeams(devTeam, qaTeam);
        //todo: enter code here
        SLLNode3 devFirst = devTeam.first;
        while (devFirst != null) {
            System.out.print(devFirst.id + " ");
            devFirst = devFirst.succ;
        }
        System.out.println();
        SLLNode3 qaFirst = qaTeam.first;
        while (qaFirst != null) {
            System.out.print(qaFirst.id + " ");
            qaFirst = qaFirst.succ;
        }
    }
}
