package com.atguigu.linkedlist;

public class SingleLinkedListDemo {
    public static void main(String[] args) {
        HeroNode hero1 = new HeroNode(1, "Superman", "Haha");
        HeroNode hero2 = new HeroNode(2, "Spider man", "Xixi");
        HeroNode hero3 = new HeroNode(3, "Batman", "Heihei");
        HeroNode hero4 = new HeroNode(4, "Superwoman", "Wow");

        SingleLinkedList singleLinkedList = new SingleLinkedList();
        singleLinkedList.addByOrder(hero1);
        singleLinkedList.addByOrder(hero4);
        singleLinkedList.addByOrder(hero2);
        singleLinkedList.addByOrder(hero3);

        singleLinkedList.list();

        HeroNode newHeroNode = new HeroNode(2, "Ohahaha", "Ohahaha");

        singleLinkedList.update(newHeroNode);

        System.out.println("The updated linked list:");
        singleLinkedList.list();

        singleLinkedList.delete(1);
        singleLinkedList.delete(4);
        singleLinkedList.delete(2);
        singleLinkedList.delete(3);
        System.out.println("After deleting:");
        singleLinkedList.list();


    }
}

class SingleLinkedList{
    /**
     * initiate the head node
     */
    private HeroNode head = new HeroNode(0, "", "");

    /**
     * add new node and do not consider the order
     */
    public void add(HeroNode heroNode){
        HeroNode temp = head;
        while (true){
           if(temp.next == null){
               break;
           }
           temp = temp.next;
        }
        temp.next = heroNode;
    }
    public void addByOrder(HeroNode heroNode){
        HeroNode temp = head;
        boolean flag = false; // the new added no existed or not, default as false
        while(true){
            if(temp.next == null){
            break;
        }
            if(temp.next.no > heroNode.no){
                break;
            } else if(temp.next.no == heroNode.no){
                flag = true;
                break;
            }
            temp = temp.next;
        }
        if(flag){
            System.out.println("The hero existed, you can't add anymore.");
        } else {
            heroNode.next = temp.next;
            temp.next = heroNode;
        }

    }
    /**
     * edit node information according the no. so no. can't be changed.
     */
    public void update(HeroNode newHeroNode){
        if(head.next == null){
            System.out.println("The linked List is empty.");
            return;
        }
        HeroNode temp = head.next;
        boolean flag = false;
        while(true){
            if(temp == null){
                break;
            }
            if(temp.no == newHeroNode.no){
                flag = true;
                break;
            }
            temp = temp.next;
        }
        if(flag){
            temp.name = newHeroNode.name;
            temp.nickname = newHeroNode.nickname;
        } else {
            System.out.printf("didn't find the node whose no is %d", newHeroNode.no);
        }
    }
    public void delete(int no){
        if(head.next == null){
            System.out.println("The linked list is empty.");
            return;
        }
        HeroNode temp = head;
        boolean flag = false;
        while(true){
            if(temp.next == null){
                break;
            }
            if(temp.next.no == no){
                flag = true;
                break;
            }
            temp = temp.next;
        }
        if (flag) {
            temp.next = temp.next.next;
        } else {
            System.out.printf("the node %d doesn't exist \n", no);
        }
    }
    /**
     * show the link list
     */
    public void list(){
        if(head.next == null){
            System.out.println("The linked list is empty.");
            return;
        }
        HeroNode temp = head.next;
        while (true){
            if(temp == null){
                break;
            }
            System.out.println(temp);
            temp = temp.next;
        }
    }

}

class HeroNode{
    public int no;
    public String name;
    public String nickname;
    public HeroNode next;
    public HeroNode(int no, String name, String nickname){
        this.no = no;
        this.name = name;
        this.nickname = nickname;
    }

    public HeroNode() {
        
    }

    @Override
    public String toString() {
        return "HeroNode{" + "no=" + no + ", name='" + name + '\'' + ", nickname='" + nickname+ "}";
    }

}
