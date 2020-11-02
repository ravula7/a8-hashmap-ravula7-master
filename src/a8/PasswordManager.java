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
        Account<K, V> account = new Account<>(key, value); //new account to add into hash table
        int hashKey = Math.abs(key.hashCode())%50; //calculate where to insert the account
        Account temp = _passwords[hashKey]; //store whatever is at _passwords
        if (_passwords[hashKey] == null) { //if there is nothing there
            _passwords[hashKey] = account; //add the account
        }
        else if (_passwords[hashKey].getWebsite().equals(key)) {
            _passwords[hashKey].setPassword(value);
        }
        else { //if there is something there
            while (temp.getNext() != null) {
                if (temp.getWebsite().equals(key)) { //in case there is a key match
                    temp.setPassword(value); //update the password
                    break;
                } else {
                    temp = temp.getNext();
                }
            }
            if (temp.getNext() == null) {
                if (temp.getWebsite().equals(key)) {
                    temp.setPassword(value);
                }
                _passwords[hashKey].setNext(account);
            }
        }
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
        for(int i = 0; i<_passwords.length; i++){
            if((K) _passwords[i] == key) {
                return (V) _passwords[i];
            }
        }
        return null;
    }
    /**
     * Returns the number of key-value mappings in the map.
     * @return the number of accounts in the map.
     */
    // TODO: size
    @Override
    public int size() {
        /*int count = 0;
        for(int i = 0; i<_passwords.length;i++){
            if(_passwords[i]!=null){
                while(_passwords[i].getNext()!=null){
                    count++;
                }
            }
        }
        return count;

         */
        return 0;
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
        int hashKey = Math.abs(key.hashCode())%50; //calculate where to remove from
        Account temp = _passwords[hashKey];
        temp.setWebsite(null);
        temp.setPassword(null);

        return null;
    }

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
