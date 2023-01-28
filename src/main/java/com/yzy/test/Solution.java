package com.yzy.test;

import org.junit.Test;

import java.util.*;

public class Solution {


    public int reverse(int x) {
        int r =0;
        while (x !=0){
            if (r>214748364 || r<-214748364) {
                return 0;
            }
            int y = x % 10;
            r=r*10+y;
            x=x/10;
        }
        return r;
    }


    public int firstUniqChar(String s) {
        char[] chars = s.toCharArray();
        int length = chars.length;
        for (int n = 0; n < length; n++) {
            int count =1;
            for (int n2 = length-1; n2 >=0; n2--) {
                if (chars[n]==chars[n2] && n!=n2){
                    count++;
                }
            }
            if (count==1){
                return n;
            }
        }
        return -1;
    }


    public int strStr(String haystack, String needle) {
        int i = haystack.length() - needle.length() + 1;
        for (int j = 0; j < i; j++) {
            if (haystack.startsWith(needle, j)){
                return j;
            }
        }
        return -1;
    }

    public String countAndSay(int n) {
        String s="1";
        if (n==1)return s;
        for (int i = 0; i < n-1; i++) {
            s= describe(s);
        }
        return s;
    }

    public String longestCommonPrefix(String[] strs) {
        //边界条件判断
        if (strs == null || strs.length == 0)
            return "";
        //默认第一个字符串是他们的公共前缀
        String pre = strs[0];
        int i = 1;
        while (i < strs.length) {
            //不断的截取
            while (strs[i].indexOf(pre) != 0)
                pre = pre.substring(0, pre.length() - 1);
            i++;
        }
        return pre;
    }

    public class ListNode {
      int val;
      ListNode next;
      ListNode(int x) { val = x; }
        ListNode(int val, ListNode next) {
            this.val = val; this.next = next; }
  }

    public class ListNode2 {
     int val;
        ListNode2 next;
     ListNode2() {}
     ListNode2(int val) {
         this.val = val; }
     ListNode2(int val, ListNode2 next) {
         this.val = val; this.next = next; }
 }

    public void deleteNode(ListNode node) {
        node.val=node.next.val;
        node.next=node.next.next;
    }


    /**
     * 力扣双指针
     * @param head
     * @param n
     * @return
     */
    public ListNode2 removeNthFromEnd2(ListNode2 head, int n) {
        ListNode2 fast = head;
        ListNode2 slow = head;
        //fast移n步，
        for (int i = 0; i < n; i++) {
            fast = fast.next;
        }
        //如果fast为空，表示删除的是头结点
        if (fast == null)
            return head.next;

        while (fast.next != null) {
            fast = fast.next;
            slow = slow.next;
        }
        //这里最终slow不是倒数第n个节点，他是倒数第n+1个节点，
        //他的下一个结点是倒数第n个节点,所以删除的是他的下一个结点
        slow.next = slow.next.next;
        return head;
    }


    /**
     * 反正链表
     * @param head
     * @return
     */
    public ListNode reverseList(ListNode head) {
        if (head==null || head.next==null){
            return head;
        }
        Stack<ListNode> s = new Stack<>();
        s.push(head);
        while (head!=null){
            s.push(head);
            head=head.next;
        }
        head=s.pop();
        ListNode left = head;
        while (!s.isEmpty()){
            left.next=s.pop();
            left=left.next;
        }
        left.next=null;
        return head;
    }

    public boolean hasCycle(ListNode head) {

        while (head!=null){
            if (head == head.next){
                return true;
            }
            ListNode next = head.next;
            head.next=head;
            head=next;
        }
        return false;
    }



    @Test
    public void testhasCycle(){
        ListNode head = new ListNode(1);
        ListNode node1 = new ListNode(2);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(1);
//        ListNode node4 = new ListNode(5);
//        ListNode node5 = new ListNode(6);
        head.next=node1;
        node1.next=node2;
        node2.next=node3;
        node3.next=head;
//        node3.next=node4;
//        node4.next=node5;
        System.out.println(hasCycle(head));
    }
    /**
     * 反正链表2
     * @param head
     * @return
     */
    public ListNode reverseList2(ListNode head) {
        if (head==null){
            return head;
        }
        ListNode newHead = new ListNode(head.val);
        while (head!=null){
            head=head.next;
            if (head!=null){
                newHead = new ListNode(head.val,newHead);
            }
        }
        return newHead;
    }

    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        list1=new ListNode(Integer.MIN_VALUE,list1);
        list2=new ListNode(Integer.MIN_VALUE,list2);
        ListNode newHead = new ListNode(Integer.MIN_VALUE);
        ListNode left = newHead;
        while (list1!=null && list2!=null){
            if(list1.val<=list2.val){
                left.next=new ListNode(list1.val);
                left=left.next;
                list1=list1.next;
            }else {
                left.next=new ListNode(list2.val);
                left=left.next;
                list2=list2.next;
            }
        }
        left.next= list1==null?list2:list1;
        newHead=newHead.next.next.next;
        return newHead;
    }


    public boolean isPalindromeNode(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        while (fast!=null){
            fast=fast.next;
            if (fast!=null){
                fast=fast.next;
                if (fast==null){
                    slow=slow.next;
                    break;
                }
            }
            slow=slow.next;
        }

        slow=reverseList2(slow);

        while (slow!=null){
            if (slow.val!=head.val){
                return false;
            }
            slow=slow.next;
            head=head.next;
        }
        return true;
    }


    public ListNode reverse(ListNode head) {
        ListNode prev = null;
        while (head != null) {
            ListNode next = head.next;
            head.next = prev;
            prev = head;
            head = next;
        }
        return prev;
    }



    @Test
    public void testtestisPalindrome(){
        ListNode head = new ListNode(1);
        ListNode node1 = new ListNode(2);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(1);
//        ListNode node4 = new ListNode(5);
//        ListNode node5 = new ListNode(6);
        head.next=node1;
        node1.next=node2;
        node2.next=node3;
//        node3.next=node4;
//        node4.next=node5;
        System.out.println(isPalindromeNode(head));
    }

    @Test
    public void testmergeTwoLists(){
        ListNode head = new ListNode(1);
        ListNode node1 = new ListNode(2);
        ListNode node2 = new ListNode(4);
        ListNode node3 = new ListNode(1);
        ListNode node4 = new ListNode(3);
        ListNode node5 = new ListNode(4);
        head.next=node1;
        node1.next=node2;

        node3.next=node4;
        node4.next=node5;

        ListNode listNode = mergeTwoLists(null, null);
        while (listNode!=null){
            System.out.println(listNode.val);
            listNode=listNode.next;
        }
    }

    @Test
    public void testreverseList(){
        ListNode head = new ListNode(1);
        ListNode node1 = new ListNode(2);
        ListNode node2 = new ListNode(3);
        ListNode node3 = new ListNode(4);
        ListNode node4 = new ListNode(5);
        head.next=node1;
        node1.next=node2;
        node2.next=node3;
        node3.next=node4;
        reverseList2(head);

    }



    /**
     * 自己写的双指针
     * @param head
     * @param n
     * @return
     */
    public ListNode2 removeNthFromEnd(ListNode2 head, int n) {
        ListNode2 right =head;
        ListNode2 left =head;
        for (int i = 0; i < n; i++) {
            right = right.next;
        }
        if (right==null){
            left=left.next;
            return left;
        }
        if (right.next==null){
            left.next=left.next.next;
            return left;
        }

        while (right.next!=null){
            right = right.next;
            left=left.next;
        }
        left.next=left.next.next;

        return head;
    }

    @Test
    public void testRemoveNthFromEnd(){
        ListNode2 head = new ListNode2(1);
        ListNode2 node1 = new ListNode2(2);
        ListNode2 node2 = new ListNode2(3);
//        ListNode2 node3 = new ListNode2(4);
//        ListNode2 node4 = new ListNode2(5);
        head.next=node1;
        node1.next=node2;
//        node2.next=node3;
//        node3.next=node4;
        removeNthFromEnd(head,2);
    }

    @Test
    public void testlongestCommonPrefix(){
        System.out.println(longestCommonPrefix(new String[]{"flower","flow","flight"}));
    }


    public String describe(String s){
        char[] chars = s.toCharArray();
        char pre ='?';
        int count=0;
        StringBuilder result = new StringBuilder();
        for (char c : chars) {
            if (c!=pre){
                if(pre!='?'){
                    result.append(count).append(pre);
                }
                count=1;
                pre =c;
            }else{
                count++;
            }
        }
        return result.append(count).append(pre).toString();
    }

    @Test
    public void testCountAndSay(){
        System.out.println(countAndSay(2));
    }


    public int strStr2(String haystack, String needle) {
        int i = haystack.length() - needle.length() + 1;
        for (int j = 0; j < i; j++) {
            if (haystack.startsWith(needle, j)){
                return j;
            }else if (!haystack.contains(needle)){
                j+=needle.length()-1;
            }
        }
        return -1;
    }


    @Test
    public void teststrstr(){
        System.out.println(strStr("hello","ll"));
    }

    public int firstUniqChars(String s) {
        int length = s.length();
        int[] count = new int[26];
        char[] chars = s.toCharArray();
        for (int i = 0; i < length; i++) {
            count[chars[i]-'a']++;
        }for (int i = 0; i < length; i++) {
            if (count[chars[i]-'a']==1){
                return i;
            }
        }
        return -1;
    }

    public int myAtoi(String s) {
        char[] chars = s.toCharArray();
        int r=0;
        // 是否校验是不是-
        boolean shouldCheck_ =true;
        // 第一个数字是不是-
        boolean first_ =false;

        for (char c : chars) {
            if (shouldCheck_){
                if (c=='-'){
                    shouldCheck_=false;
                    first_=true;
                }else if (isNum(c)){
                    shouldCheck_=false;
                    r=toNum(c);
                }else if(c==' '){

                }else if(c =='+'){
                    shouldCheck_=false;
                } else{
                    return 0;
                }
            }else {
                if(isNum(c)){
                    if(r==214748364){
                        //-2147483648
                        //2147483647
                        int cNum = toNum(c);
                        if(first_){
                            if (cNum <=7){
                               r=r*10+cNum;
                           }else {
                               return -2147483648;
                           }
                        }else {
                            if (cNum<=7){
                                r=r*10+cNum;
                            }else {
                                return 2147483647;
                            }
                        }

                    }else if (r>214748364){
                        if (first_) {
                            return -2147483648;
                        }else {
                            return 2147483647;
                        }
                    }else{
                        r=r*10+toNum(c);
                    }
                }else if(c=='.'){
                    return first_?r*-1:r;
                }else if(c == '+' || c == '-'){
                    return first_?r*-1:r;
                }else if (!isNum(c)){
                    return first_?r*-1:r;
                }
            }
        }
        return first_?r*-1:r;
    }


    public boolean isNum(char c){
        return c>='0' && c<='9';
    }

    public int toNum(char c){
        if (c=='-'){
            return -1;
        }else if (c>='0' && c<='9'){
            return c-48;
        }else {
            return 10;
        }
    }

    @Test
    public void testmyAtoi(){
        System.out.println(myAtoi("-5-"));
    }


    public boolean isPalindrome(String s) {
        StringBuilder result= new StringBuilder();
        for (char c : s.toLowerCase().toCharArray()) {
            if (c>='a' && c<='z'){
                result.append(c);
            }
        }
        char[] chars = result.toString().toCharArray();
        int l = chars.length /2;
        if (l==0){
            return true;
        }
        for (int i = 0; i < l; i++) {
            if (chars[i] !=chars[chars.length-1-i]){
             return false;
            }
        }
        return true;
    }

    @Test
    public void testisPalindrome(){
        System.out.println(1/2);
        System.out.println(0/2);
        System.out.println(isPalindrome("0P"));
        System.out.println("0P".toLowerCase());
        System.out.println('0'<='z');
    }

    public boolean isAnagram(String s, String t) {
        int x=1;
        int y=1;
        char[] c1 = s.toCharArray();
        char[] c2 = t.toCharArray();
        for (char c : c1) {
            x+=(c-100)*(c%100);
        }
        for (char c : c2) {
            y+=(c-100)*(c%100);
        }
        return s.length() == t.length() && x==y;
    }

    @Test
    public void testisAnagram(){
        System.out.println(isAnagram("hqbqo","lsnma"));
    }

    @Test
    public void testfirstUniqChar(){
        System.out.println(firstUniqChar("jnaprrmwbbujwrgqqtccvkjvxwiimcvmokrdsbgpubcwlveeqeprvoofeepsntdrujehsthrdwunjfedhltnarwsqjxbtuwnnkklsqqmhxthicnwthvenkcvuxhxvpxihelaqariwlxtamqmocwawtcnbmilvswcurgffljwjlhbjknfpkwqckvtfbjwsosetpttjabnjxdcmwtcnievjilfcgtxmdmwmheivjrfvxvnxosrsmiwtvgnwdnwtbtogrwwxuhpetcdmttnvgttxilclxiuhpaodvmnbkwkakncbvwdgwfmitvfamuxapsfsculbtmwqvteqmsvndnctebfvaqkghculsgcjoctdmhaxqasspmermcsbencbaabxdlkxfpcdpxhaaxdnabtclwfwpcrrstxeodjnoechotqkvqoxovnoqvflligxumlttvbccimhqelfxlnotqvwfbkqogjjisxujsjgrehlosbiwpqtoraqihuvkvtaugcirbkrthlmjernseopgqansjutvvtfjxufudllhkaqgtldcupaexegdpbqxvrgxownqameonhaqwxtxetaitmctblfcfwvfdhwghvejhpuwootbxkvkhiarwlcegbrffpcfixtgbqfpthuqknrrbrkpwqqpakrnepxhmrsvktrmudomimlxjhhlkknbtspocopsdlxqtxcnjabnhnksqaxocsltfhcqmmrhmotndmwseqgshsitfgcxfhjebektvrfoqbhfdlxlkdlebsubsiiqerwwngxwlotppejqddepopkdfwoomxrpgjmhbhblwslrqidgsuexnwbpkfgbnknwuokahoiqhofvtmdxjhbtkqcpbpubnbutvqibeuewobrmbidsptstdlenbeqpuewwcinkshfncdhesvsqfahharpptnddjmtjtetsbbeeduhvvsirsoiwcjkwpjleeautxhjlbsxntfcjdpmfh"));
    }



    @Test
    public void testReverse(){
        System.out.println(reverse(1463847412));
        System.out.println(964632435*10);
        System.out.println(964632435);
        System.out.println(Integer.MIN_VALUE);
    }


    public char[] reverseString(char[] s) {
        int left =0;
        int right =s.length-1;
        while (left<=right){
            char t=s[left];
            s[left]=s[right];
            s[right]=t;
            left++;
            right--;
        }
        return s;
    }


    public void rotate(int[][] matrix) {
        //对称行先交换
        int length = matrix.length;
        for (int i = 0; i < length / 2; i++) {
            int[]temp=matrix[i];
            matrix[i]=matrix[length-i-1];
            matrix[length-i-1] =temp;
        }
        // 按中间交换
        for (int i = 0; i < length; i++) {
            for (int j = i+1; j < length; j++) {
                int temp = matrix[i][j];
                matrix[i][j]=matrix[j][i];
                matrix[j][i]=temp;
            }
        }


    }

    public boolean isValidSudoku(char[][] board) {
        int n = board.length;

        for (int i = 0; i < n; i++) {
            HashSet<Character> line = new HashSet<>();
            HashSet<Character> col = new HashSet<>();
            HashSet<Character> box = new HashSet<>();

            for (int j = 0; j < n; j++) {
                if (board[i][j]!='.' && !line.add(board[i][j])){
                    return false;
                }
                if (board[j][i]!='.' && !col.add(board[j][i])){
                    return false;
                }
                int a =(i/3)*3 + j/3;
                int b =(i%3)*3 + j%3;
                if (board[a][b]!='.' && !box.add(board[a][b])){
                    return false;
                }

            }
        }

        return true;


    }

    /**
     * 2,0 ->0
     * 2,1 ->0
     * 2,2 ->0
     * 2,3 ->1
     * 2,4 ->1
     * 2,5 ->1
     * 2,6 ->2
     * 2,7 ->2
     * 2,8 ->2
     *
     *
     * 4,0 ->0
     * 4,1 ->0
     * 4,2 ->0
     * 4,3 ->1
     * 4,4 ->1
     * 4,5 ->1
     * 4,6 ->2
     * 4,7 ->2
     * 4,8 ->2
     *
     */



    // 10 00，11 01 ，12 02 ，13 10, 14 11, 15 12, 16 20, 17 21 , 18 22
    @Test
    public void testisValidSudoku(){

    }


    public static int[]intersect(int []nums1,int []nums2){
        Arrays.sort(nums1);
        Arrays.sort(nums2);

        int [] result=new int[Math.min(nums1.length, nums2.length)];
        int x =0;
        int k=0;
        int i = 0;
        while (i != nums2.length && k != nums1.length) {
            int n1 = nums2[i];
            int n2 = nums1[k];
            if (n1 == n2) {
                result[x] = n1;
                x++;
                i++;
                k++;
            } else if (n1 < n2) {
                i++;
            } else {
                k++;
            }
        }
        return Arrays.copyOfRange(result,0,x);
    }

    public  int[] plusOne(int[] digits) {
        for (int i=digits.length-1;i>=0;i--){
            digits[i]++;
            if ((digits[i]=digits[i]%10)!=0){
                return digits;
            }
        }
        int[] ints = new int[digits.length + 1];
        ints[0]=1;
        return ints;
    }


    /**
     * 双指针遍历交换
     * @param nums
     */
    public void moveZeroes3(int[] nums) {
        int n = nums.length, left = 0, right = 0;
        while (right < n) {
            if (nums[right] != 0) {
                swap(nums, left, right);
                left++;
            }
            right++;
        }
    }

    public int[] twoSum(int[] nums, int target) {
        int[] result = new int[2];
        Map<Integer,Integer>map=new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            if (map.containsKey(target-num)){
                result[0]=i;
                result[1]=map.get(target-num);
            }else {
                map.put(num,i);
            }
        }
        return result;
    }

    @Test
    public void testTwoSum(){
        int[] ints = twoSum(new int[]{2,0,11,7}, 9);
        for (int i = 0; i < ints.length; i++) {
            System.out.println(ints[i]);
        }
    }

    @Test
    public void test3(){
        int[] ints = {1, 0, 1, 0, 1};
        moveZeroes3(ints);
        for (int anInt : ints) {
            System.out.println(anInt);
        }
    }

    public void swap(int[] nums, int left, int right) {
        int temp = nums[left];
        nums[left] = nums[right];
        nums[right] = temp;
    }


    public void moveZeroes2(int[] nums) {
        int index = 0;
        for (int num : nums) {
            if (num != 0) {
                nums[index++] = num;
            }
        }
        for (int i = index; i < nums.length; i++) {
            nums[i] = 0;
        }
    }

    // 0,1,0,3,12
    public void moveZeroes(int[] nums) {
        for (int i = 0; i < nums.length -1; i++) {
            if (nums[i]==0){
                // 找到下个不为0的交换位置
                int n=i+1;
                while (n<nums.length-1 && nums[n]==0){
                    n++;
                };
                nums[i]=nums[n];
                nums[n]=0;
            }
        }
    }

    @Test
    public void testMoveZeroes(){
        moveZeroes(new int[]{0,1,0,3,12});
    }

    @Test
    public void testPlusOne(){
        for (int i : plusOne(new int[]{8,9,9,9})) {
            System.out.println(i);
        }
    }

    public static void main(String[] args) {
        int[] nums1 = new int[]{1,2,2,3,3};
        int[] nums2 = new int[]{3,5,2,2};
        int[] intersect = intersect(nums1, nums2);
        for (int i : intersect) {
            System.out.println(i);
        }
    }

}
