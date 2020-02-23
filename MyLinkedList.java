package stark;

import java.util.Scanner;

class Node
{
    int data;
    Node next;

    public Node(int data) {
        this.data = data;
        this.next = null;
    }
}
public class MyLinkedList {
    Node head;

    public MyLinkedList() {
        this.head = null;
    }

    public void insertAtLast(Node newnode)
    {
        if(head==null)
        {
            head = newnode;
            System.out.println("Node Inserted.");
        }
        else
        {
            Node temp = head;
            while (temp.next!=null)
            {
                temp = temp.next;
            }
            temp.next = newnode;
        }
    }
    public void insertAtBeginning(Node newnode)
    {
        if(head==null)
        {
            System.out.println("Node Inserted.");
            head = newnode;
        }
        else
        {
            System.out.println("Node Inserted.");
            newnode.next = head;
            head = newnode;
        }
    }
    public void insertAtPosition(int pos, Node newnode)
    {
        int c=0;
        Node temp = head;
        while(temp!=null)
        {
            c++;
            temp = temp.next;
        }

        if(head == null)
        {
            head = newnode;
        }
        else if(pos == 1)
        {
            insertAtBeginning(newnode);
        }
        else if(pos==(c+1))
        {
            insertAtLast(newnode);
        }
        else if(pos>1 && pos<(c+1))
        {
            System.out.println("Node Inserted.");
            temp = head;
            for(int i=1; i<(pos-1); i++)
            {
                temp = temp.next;
            }
            Node temp2 = temp.next;
            temp.next = newnode;
            temp = temp.next;
            temp.next = temp2;
        }
        else
        {
            System.out.println("Enter valid position only.");
        }
    }
    public void deleteAtBeginning()
    {
        if(head == null)
        {
            System.out.println("No node present to delete.");
        }
        else
        {
            System.out.println(head.data+" deleted.");
            head = head.next;
        }
    }
    public void deleteAtLast()
    {
        if(head == null)
        {
            System.out.println("No node present to delete.");
        }
        else
        {
            Node temp = head;
            while(temp.next.next!=null)
            {
                temp = temp.next;
            }
            System.out.println(temp.next.data+" deleted.");
            temp.next = null;
        }
    }
    public void traverse()
    {
        if(head == null)
        {
            System.out.println("Empty Link List.");
        }
        else
        {
            Node temp = head;
            while(temp!=null)
            {
                System.out.println(temp.data);
                temp = temp.next;
            }
        }
    }
}

class MyLinkListMain
{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        MyLinkedList obj = new MyLinkedList();
        while(true)
        {
            System.out.println("Enter 1 to insert node at any position: ");
            System.out.println("Enter 2 to delete at beginning position: ");
            System.out.println("Enter 3 to delete at last position: ");
            System.out.println("Enter 4 to traverse the link list: ");
            System.out.println("Enter 5 to exit: ");
            int choice = sc.nextInt();
            switch(choice)
            {
                case 1:
                    System.out.println("Enter the position: ");
                    int pos = sc.nextInt();
                    System.out.println("Enter the data: ");
                    int r = sc.nextInt();
                    Node n1 = new Node(r);
                    obj.insertAtPosition(pos,n1);
                    break;
                case 2:
                    obj.deleteAtBeginning();
                    break;
                case 3:
                    obj.deleteAtLast();
                    break;
                case 4:
                    obj.traverse();
                    break;
                case 5:
                    System.exit(0);
                    break;
                default:
                    System.out.println("Enter correct option.");
            }
        }
    }
}
