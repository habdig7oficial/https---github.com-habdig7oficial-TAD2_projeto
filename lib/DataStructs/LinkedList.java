package lib.DataStructs;

import java.util.Iterator;

import tokens.asm.Instruction;

public class LinkedList <Generic> implements Iterable<Generic> {

    private Node<Generic> root = null;
    private Node<Generic> leaf = null;

    private int length = 0; 
    
    public int getLength() {
        return length;
    }

    public void append(Generic element){
        if(root == null){
            root = new Node<Generic>(element);
            leaf = root;
            this.length++;
            return;
        }
        
        Node<Generic> n = new Node<Generic>(element);
        
        if(leaf != null) {
            leaf.setNext(n);
        }
        leaf = n; 

        this.length++; 
    }

    public void prepend(Generic element){  

        root = new Node<Generic>(element, root);
        if(this.length == 0) {
            this.leaf = root;
        }
        this.length++;
    }

    public Node<Generic> getLast() {
        return this.leaf;
    }

    public Node<Generic> getFirst() {
        return this.root;
    }

    public boolean rmFirst(Generic element) {
        Node<Generic> e = root; 
        Node<Generic> last = null; 
        
        for(int i = 0; i < this.length; i++){ 
            if(e != null && e.getElement().equals(element)){
                if(last != null) {
                    last.setNext(e.getNext());
                } else {
                    this.root = e.getNext();
                }
                if(e == this.leaf) {
                    this.leaf = last;
                }
                this.length--;
                if(this.length <= 0){
                    this.leaf = null;
                    this.root = null;
                } 
                return true; 
            }
            
            last = e;    
            if (e != null) {
                 e = e.getNext();
            } else {
                 break; 
            }
        }
        
        return false;
    }

    public void clean(){
        this.length = 0;
        this.leaf = null;
        this.root = null;
    }

    public Iterator<Generic> iterateToIndex(int index){
        Iterator<Generic> iter = this.iterator();
        for (int i = 0; iter.hasNext() && i < index; i++) {
            iter.next();
        }
        return iter;
    }

    @Override
    public Iterator<Generic> iterator(){
        return new LinkedListIterator<Generic>(this);
    }

    @Override
    public String toString() {
        String str = "";
        Node<Generic> e = root;
        
        for(int i = 0; i < this.length; i++){
            if (e == null) {
                 throw new IllegalStateException("Node unexpectedly null in toString loop.");
            }
            
            str += "\"" + e.getElement().toString() + "\" ";
            e = e.getNext();
        }
        return "[" + str.trim() + "]";
    }

    public String toCleanString() {
        String str = "";
        Node<Generic> e = root;
        
        for(int i = 0; i < this.length; i++){
            if (e == null) {
                 throw new IllegalStateException("Node unexpectedly null in toCleanString loop.");
            }
            str += e.getElement().toString() + "\n";
            e = e.getNext();
        }
        return str;
    }
}

