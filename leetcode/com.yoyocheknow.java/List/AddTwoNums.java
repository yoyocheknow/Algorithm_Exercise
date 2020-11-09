package List;

/**
 * 两个链表之和
 *
 * @author zhihua on 2020/11/9
 */
public class AddTwoNums {

    /**
     * Definition for singly-linked list.
     * */
      public static class ListNode {
          int val;
          ListNode next;
          ListNode() {}
          ListNode(int val) { this.val = val; }
          ListNode(int val, ListNode next) { this.val = val; this.next = next; }
     }

    public  ListNode addTwoNumbers(ListNode l1, ListNode l2) {
          ListNode result=new ListNode();
          ListNode resultHead = result;
          int addFlag=0;
          while(l1!=null &&l2!=null){
            int sum = l1.val+l2.val+addFlag;
              result.next=new ListNode(sum%10);
              result=result.next;

              addFlag = sum/10;
              l1=l1.next;
              l2=l2.next;
          }
          while(l1!=null){
              int sum = l1.val+addFlag;
              result.next=new ListNode(sum%10);
              result=result.next;
              addFlag = sum/10;
              l1=l1.next;
          }
          while(l2!=null){
              int sum = l2.val+addFlag;
              result.next=new ListNode(sum%10);
              result=result.next;
              addFlag = sum/10;
              l2=l2.next;
          }
          if(addFlag!=0){
              ListNode r = new ListNode(addFlag);
              result.next=r;
          }
          return resultHead.next;
    }

    //更简洁的写法
    public  ListNode addTwoNumbers1(ListNode l1, ListNode l2) {
        ListNode head = new ListNode(0);
        ListNode dummy = head;

        int carry = 0;

        while(l1 != null || l2 != null){
            int x = (l1 != null) ? l1.val : 0;
            int y = (l2 != null) ? l2.val : 0;
            int sum = x + y + carry;

            carry = sum / 10;
            dummy.next = new ListNode(sum % 10);
            dummy = dummy.next;

            if(l1 != null)
                l1 = l1.next;

            if(l2 != null)
                l2 = l2.next;
        }

        if(carry > 0)
            dummy.next = new ListNode(carry);

        return head.next;
    }

    public static void main(String args[]){
        AddTwoNums addTwoNums = new AddTwoNums();
        ListNode l1=new ListNode(9);
        ListNode l2=new ListNode(9);
        ListNode l3=new ListNode(9);
        ListNode l4=new ListNode(9);
        ListNode l5=new ListNode(9);
        ListNode l6=new ListNode(9);
        ListNode l7=new ListNode(9);
        l1.next=l2;
        l2.next=l3;
        l3.next=l4;
        l4.next=l5;
        l5.next=l6;
        l6.next=l7;
        ListNode r1=new ListNode(9);
        ListNode r2=new ListNode(9);
        ListNode r3=new ListNode(9);
        ListNode r4=new ListNode(9);
        r1.next=r2;
        r2.next=r3;
        r3.next=r4;
        ListNode result = addTwoNums.addTwoNumbers(l1,r1);
        while (result!=null){
            System.out.println(result.val);
            result=result.next;
        }
    }
}