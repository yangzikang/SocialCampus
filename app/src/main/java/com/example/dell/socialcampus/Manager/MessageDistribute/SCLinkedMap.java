package com.example.dell.socialcampus.manager.messageDistribute;

/**
 * Created by atong on 2016/12/13.
 */

public class SCLinkedMap {
    private class Entry {
        private Object value;
        private String key;
        private Entry next = null;

        Entry(String key,Object value) {
            this.key = key;
            this.value = value;
        }
    }

    private Entry first = null;

    public void insertFirst(String key,Object value) {
        Entry entry = new Entry(key,value);
        entry.next = first;
        first = entry;
    }

    public Object find(String key) throws Exception {
        if (first == null)
            throw new Exception("LinkedList is empty!");
        Entry cursor = first;
        while (cursor != null) {
            if (cursor.key.equals(key)) {
                return cursor.value;
            }
            cursor = cursor.next;
        }
        return null;
    }

    public void remove(String key) throws Exception{
        if(first == null)
            throw new Exception("LinkedList is empty!");
        if(first.key.equals(key)){
            first = first.next;
        } //如果要删除的是第一个节点，直接移除
        else{
            Entry beforeCursor = first;
            Entry cursor = first.next;
            while(cursor != null){
                if(cursor.key.equals(key)){
                    beforeCursor.next = cursor.next;
                }
                beforeCursor = cursor;
                cursor = cursor.next;
            }
        }
    }

    public boolean isEmpty() {
        return (first == null);
    }
}
