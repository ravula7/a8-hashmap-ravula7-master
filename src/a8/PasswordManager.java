package a8;

import java.util.*;

public class PasswordManager<K,V> implements Map<K,V> {
    private static final String MASTER_PASSWORD = "YOUR PASSWORD HERE";
    private Account[] _passwords;
    public PasswordManager() {
       // Account[]
         _passwords = new Account[50]; //array of account type --> can use all account methods
    }


    // TODO: put
    /**
     * Creates an Account object using the key value pair,
     * and inserts the object at the appropriate index
     * based on the hash of they key. If the key already
     * exists in map, update its value.
     * @param key: the website name
     * @param value: the password
     */
    @Override
    public void put(K key, V value) {
        Account account = new Account<>(key,value);
        int hashKey = Math.abs(key.hashCode()) % 50; //calculate where to insert the account
        Account temp = _passwords[hashKey];
        if(temp == null){
            _passwords[hashKey] = account;
        }
        else{
            while(temp.getNext() !=null){
                if(temp.getWebsite().equals(key)){
                    temp.setPassword(value);
                    return;
                }
                temp = temp.getNext();
            }
            if(temp.getWebsite().equals(key)){
                temp.setPassword(value);
            }
            else{
                temp.setNext(account);
            }
        }

        /*
        Account<K, V> account = new Account<>(key, value); //new account to add into hash table
        int hashKey = Math.abs(key.hashCode())%50; //calculate where to insert the account
        Account temp = _passwords[hashKey]; //store whatever is at _passwords
        if (_passwords[hashKey] == null) { //if there is nothing there
            _passwords[hashKey] = account; //add the account
        }
        else if (_passwords[hashKey].getWebsite().equals(key)) { //size doesn't update because just replacing the password
            _passwords[hashKey].setPassword(value);
        }
        else { //if there is something there
            while (temp.getNext() != null) {
                if (temp.getWebsite().equals(key)) { //in case there is a key match
                    temp.setPassword(value); //update the password
                    break;
                }
                else { //go to next
                    temp = temp.getNext();
                }
            }
            if (temp.getNext() == null) {
                if (temp.getWebsite().equals(key)) {
                    temp.setPassword(value);
                }
                else {
                    _passwords[hashKey].setNext(account);
                }
            }
        }

         */
    }
/*
               else{
               while(_passwords[hashKey]!= null) { //traverse through the list //or temp.getNext() null?
                   temp = temp.getNext();
               }
               temp.setNext(account);
           }     */


    // TODO: get
    /**
     * Returns the value associated with the given key.
     * This operation should have O(1) runtime.
     * If the key is not in the array, return null.
     * @param key
     * @return the value (password) associated with that key
     */
    @Override
    public V get(K key) {
        int hashKey = Math.abs(key.hashCode()) % 50; //calculate where to insert the account
        Account temp = _passwords[hashKey];
        while (temp != null) {
            if (temp.getWebsite().equals(key)) {
                return (V) temp.getPassword();
            }
            temp = temp.getNext();
        }
        return null;
    }


        /*for(int i = 0; i<_passwords.length; i++){
            if((K) _passwords[i] == key) {
                return (V) _passwords[i];
            }
        }
        return null;

         */

    /**
     * Returns the number of key-value mappings in the map.
     * @return the number of accounts in the map.
     */
    // TODO: size
    @Override
    public int size() {
        int count = 0;
        for(int i = 0; i<_passwords.length;i++) {
            if (_passwords[i] != null) {
                Account temp = _passwords[i];
                while (temp != null) {
                    count++;
                    temp = temp.getNext();
                }
            }
        }
        return count;
    }
    /**
     * Returns a Set of all the keys (websites) contained in this map.
     *
     * @return A set of the keys contained in the map
     */
    // TODO: keySet
    @Override
    public Set<K> keySet() {
        return null;
    }
    /**
     * Removes the Key and value pair from the map
     * and returns the removed value.
     * If the key is not in the array, return null.
     * @param key to be removed
     * @return the value (password) that was removed
     */
    // TODO: remove
    @Override
    public V remove(K key) {
        int hashKey = Math.abs(key.hashCode()) % 50;
        Account<K, V> temp = _passwords[hashKey];
        V password = null;
        if (temp == null) {
            return null;
        }
        else {
            if(_passwords[hashKey].equals(key)){ //checks for the first node
                _passwords[hashKey] = _passwords[hashKey].getNext(); //overwrite the value with the next
            }
            while (temp != null) { //checks for the remaining nodes
                if (temp.getWebsite().equals(key)) { //when you find the key
                    password = temp.getPassword(); //need to return the value there, so storing it
                    //next steps before you break to fix up the list:
                    if (temp.getNext() == null) { //if you have reached the end of the list
                        _passwords[hashKey] = null; //make the last key and value null because there is nothing there anymore and no next to link it to
                        break; //done!
                    }
                    else { //if you haven't reached the end of the list
                        //need to link the temp to the key and value after what was removed
                        temp.setNext((temp.getNext()).getNext()); //so getNext used twice-overwrote
                        break;
                    }
                }
                else { //if you didn't find the key yet, go to the next and continue the while loop
                    temp = temp.getNext();
                }
            }
            return password;
        }
    }
    /**
     * Returns a list the website names
     * that have a password matching the parameter
     *
     * @return A List containing the keys of accounts whose password
     * match the parameter
     */
    // TODO: checkDuplicate
    @Override
    public List<K> checkDuplicate(V value) {

        return null;
    }

    // TODO: checkMasterPassword
    @Override
    public boolean checkMasterPassword(String enteredPassword) {
        return false;
    }

    /*
    Generates random password of input length
     */
    @Override
    public String generateRandomPassword(int length) {
        int leftLimit = 48; // numeral '0'
        int rightLimit = 122; // letter 'z'
        int targetStringLength = length;
        Random random = new Random();

        String generatedString = random.ints(leftLimit, rightLimit + 1)
                .filter(i -> (i <= 57 || i >= 65) && (i <= 90 || i >= 97))
                .limit(targetStringLength)
                .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
                .toString();

        return generatedString;
    }

    /*
    Used for testing, do not change
     */
    public Account[] getPasswords() {
        return _passwords;
    }
}
