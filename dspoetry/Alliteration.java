package dspoetry;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

class Alliteration extends MeteredPoem{
    DSStack stack;
    String phoneme = rndPhone();
    
    @Override
    String generatePoem(){
        stack  = new DSStack();
        stack.push("S");
        String sentence = "";
        
        while(!stack.isEmpty()){
            // Pop item from stack
            String x = stack.pop();
            switch(x){
                case "S":
                    Sentence();
                    break;
                case "ART":
                    Article();
                    break;
                case "VP":
                    VerbPhrase();
                    break;
                case "NP":
                    NounPhrase();
                    break;
                case "A":
                    Adjective();
                    break;
                case "PP":
                    PrepositionalPhrase();
                    break;
                case "N":
                    Noun();
                    break;
                case "V":
                    Verb();
                    break;
                case "P":
                    Preposition();
                    break;
                case "Q":
                    Question();
                    break;
                default: // Terminal. Add to end of sentence
                    sentence = sentence + " " + x;
            }
        }
        
        return sentence;
    }
    
    /**
     * Grammar rules for Sentences (S)
     */
    void Sentence(){
        int x = (int)(Math.random() * 4); // random # 0, 1, 2 or 3
        switch(x){
            case 0:
                stack.push("VP");
                stack.push("NP");
                break;
            case 1:
                stack.push("S");
                stack.push("I find that");
                stack.push("V");
                stack.push("Whenever I");
                break;
            case 2:
                stack.push("PP");
                stack.push("N");
                stack.push("A");
                stack.push("my");
                stack.push("V");
                stack.push("N");
                stack.push("A");
                stack.push("ART");
                break;
            case 3:
                stack.push("Q"); // Create a question instead
                break;
            default:
                break;
        }
    }
    
    /**
     * Grammar rules for Articles (ART)
     */
    void Article(){
        int x = (int)(Math.random() * 3); // random # 0, 1 or 2
        switch(x){
            case 0:
                stack.push("a");
                break;
            case 1:
                stack.push("an");
                break;
            case 2:
                stack.push("the");
                break;
            default:
                break;
        }
    }
    
    
    /**
     * Grammar rules for Verb Phrases (VP)
     * Mary and Madeleine
     */
    void VerbPhrase(){
        int x = (int)(Math.random() * 5); // random # 0, 1, 2 or 3
        switch(x){
            case 0:
                stack.push("N");
                stack.push("ART");
                stack.push("V");
                break;
            case 1:
                stack.push("NP");
                //			stack.push("ART");
                stack.push("A");
                stack.push("V");
                break;
            case 2:
                stack.push("NP");
                //			stack.push("ART");
                stack.push("V");
                stack.push("happily");
                break;
            case 3:
                stack.push("V");
                stack.push("and");
                stack.push("V");
                break;
            case 4:
                stack.push("VP");
                stack.push("and");
                stack.push("VP");
                break;
            default:
                break;
        }
        
    }
    
    
    /**
     * Grammar rules for Noun Phrases (NP)
     * Peter and Kathryn
     *
     * XXX Reverse
     */
    void NounPhrase(){
        int x = (int) (Math.random() * 7); //Put in the number of cases we come up with
        switch(x){
            case 0: // "Article" "Noun" like "the dog"
                stack.push("N");
                stack.push("ART");
                break;
                
            case 1: // "Article" "Adj" Noun" like "the big dog"
                stack.push("N");
                stack.push("A");
                stack.push("ART");
                break;
                
            case 2: // "Article" "Adj" "Adj" Noun" like "the great big dog"
                stack.push("N");
                stack.push("A");
                stack.push("A");
                stack.push("ART");
                break;
                
            case 3: // "article" "noun" and "article" "noun" like the cat and the dog
                stack.push("N");
                stack.push("ART");
                stack.push("and");
                stack.push("N");
                stack.push("ART");
                break;
                
            case 4: // "article" "adjective" "noun" and "article" "noun" like the big cat and the dog
                stack.push("N");
                stack.push("A");
                stack.push("ART");
                stack.push("and");
                stack.push("N");
                stack.push("ART");
                break;
                
            case 5: // "article" "noun" and "article" "adjective" "noun" like the cat and the red dog
                
                stack.push("N");
                stack.push("ART");
                stack.push("and");
                stack.push("N");
                stack.push("A");
                stack.push("ART");
                break;
                
            case 6: // "article" "adjective" "noun" and "article" "adjective""noun" like the big cat and the red dog
                stack.push("N");
                stack.push("A");
                stack.push("ART");
                stack.push("and");
                stack.push("N");
                stack.push("A");
                stack.push("ART");
                break;
            default:
                break;
        }
    }
    
    
    
    /**
     * Grammar rules for Adjectives (A)
     * Paul and David
     *
     * XXX Please re-work this so that it loops over wordMap.values()
     */
    void Adjective(){
        ArrayList<String> adjs = new ArrayList<String>();
        for( String w : Poet.wordMap.keySet()){
            String[] phones = Poet.wordMap.get(w).phonemes;
            if(Poet.wordMap.get(w).partOfSpeech.contains("A") && phones != null){
                if(phones[0].equals(phoneme))
                    adjs.add(w);
            }
        }
        int n  = (int)(Math.random() * adjs.size());
        stack.push(adjs.get(n));
        
    }
    
    
    
    /**
     * Grammar rules for Prepositional Phrases (PP)
     * Kyle and Julian
     *
     * XXX Reverse. And also add some specific phrases.
     */
    void PrepositionalPhrase(){
        int x = (int) (Math.random() * 6);
        switch(x){
            case 0:
                stack.push("N");
                stack.push("with");
                break;
            case 1:
                stack.push("NP");
                stack.push("and");
                stack.push("NP");
                stack.push("P");
                break;
            case 2:
                stack.push("N");
                stack.push("the");
                stack.push("P");
                break;
            case 3:
                stack.push("NP");
                stack.push("P");
                break;
            case 4:
                stack.push("NP");
                stack.push("or");
                stack.push("NP");
                stack.push("P");
                break;
            case 5:
                stack.push("N");
                stack.push("for");
                
                
                
                
        }
        
        
    }
    
    
    
    /**
     * Grammar rules for Nouns (N)
     * Regina and Anna
     */
    void Noun(){
        
        ArrayList<String> nouns = new ArrayList<String>();
        
        for( String w : Poet.wordMap.keySet()){
            String[] phones = Poet.wordMap.get(w).phonemes;
            if(Poet.wordMap.get(w).partOfSpeech.contains("N") && phones != null){
                if(phones[0].equals(phoneme))
                    nouns.add(w);
            }
        }
        int n  = (int)(Math.random() * nouns.size());
        stack.push(nouns.get(n));
        
        
    }
    
    
    /**
     * Verb method that takes no parameters, for backward-compatibility
     *
     * Selects either transitive or intransitive at random
     */
    void Verb(){
        double r = Math.random();
        if(r < 0.5)
            Verb("i");
        else
            Verb("t");
    }
    
    
    
    /**
     * Grammar rules for Verbs (V)
     * Amena and Joanie
     */
    void Verb(String choice){
        ArrayList<String> trans = new ArrayList<String>();
        ArrayList<String> intrans = new ArrayList<String>();
        
        for (String w : Poet.wordMap.keySet()){
            String[] phones = Poet.wordMap.get(w).phonemes;
            if (Poet.wordMap.get(w).partOfSpeech.contains("i") && phones != null){
                if(phones[0].equals(phoneme))
                    intrans.add(w);
            }
            if (Poet.wordMap.get(w).partOfSpeech.contains("Vt") && phones != null){
                if(phones[0].equals(phoneme))
                    trans.add(w);
            }
        }
        int t = (int)(Math.random() * trans.size());
        int i = (int)(Math.random() * intrans.size());
        int x = 0;
        if(choice.equals("t")){
            stack.push(trans.get(t));
        }
        if(choice.equals("i")){
            stack.push(intrans.get(i));
        }
        if(choice.equals("")){
            switch(x){
                case 0:
                    stack.push(trans.get(t));
                    break;
                case 1:
                    stack.push(intrans.get(i));
                    break;
            }
        }
    }
    
    
    
    /**
     * Grammar rules for Prepositions (P)
     * Minh and Yeabkal
     */
    void Preposition(){
        ArrayList<String> preps = new ArrayList<String>();
        for( String w : Poet.wordMap.keySet()){
            if(Poet.wordMap.get(w).partOfSpeech.contains("P")){
                preps.add(w);
            }
        }
        int n  = (int)(Math.random() * preps.size());
        stack.push(preps.get(n));
    }
    
    /**
     * Grammar rules for Questions (Q)
     * Diego and Mary Kate
     */
    void Question(){
        int x = (int)(Math.random() * 3); // random # 0, 1, or 2
        switch(x){
                
                /** CASE 0
                 * Declarative sentence with a question mark
                 * Ex: It is snowing in Florida?
                 */
            case 0:
                stack.push("?");
                stack.push("VP");
                stack.push("NP");
                break;
                
                
                /** CASE 1
                 * "Wh" interrogative sentences
                 * Ex: What are you doing?
                 * Ex: Why did you go to the park?
                 */
            case 1:
                stack.push("?");
                stack.push("VP");
                stack.push("NP");
                int y = (int)(Math.random() * 2); // random # 0 or 1
                switch(y){ // switch btwn "do"/"does"
                    case 0:
                        stack.push("do");
                        break;
                    case 1:
                        stack.push("does");
                        break;		
                }
                int z = (int)(Math.random() * 4); // random # 0, 1, 2, or 3
                switch(z){ //switch btwn interrogative openers
                    case 0:
                        stack.push("When");
                        break;
                    case 1:
                        stack.push("Why");
                        break;
                    case 2:
                        stack.push("What");
                        break;
                    case 3:
                        stack.push("Which");
                        break;
                }	   
                break;
                
                
                /** CASE 2
                 * yes/no interrogative sentences
                 * Ex: Did you walk the dog?
                 * Ex: Are you hungry?
                 */
            case 2:
                stack.push("?");
                stack.push("PP");
                stack.push("VP");
                stack.push("NP");
                int y1 = (int)(Math.random() * 4); // random # 0, 1, 2, or 3
                switch(y1){ //switch btwn different verbal forms of do, be, be able
                    case 0:
                        stack.push("Did");
                        break;
                    case 1:
                        stack.push("Do");
                        break;
                    case 2:
                        stack.push("Can");
                        break;
                    case 3:
                        stack.push("Are");
                        break;
                }
                break;
                
        }
    }
    
    
    
    String generateSonnet(){
        
        int word = 0;
        int lline = 0;
        int stanza = 0;
        
        Poet.setVocab("shakespeare.txt");
        poem = "";
        
        while (word < 7 && lline < 4 && stanza < 4) {
            
            String rhymingWord = Poet.getRW("AH V");
            
            if(word < 6){
                poem = poem + rhymingWord + " ";
                word++;
            }
            
            if(word == 6){
                poem = poem + rhymingWord + " ";
                word++;
            }
            
            if(word == 7){
                poem = poem + "\n";
                word = 0;
                lline++;
            }
            
            if(lline == 4){
                poem = poem + "\n";
                lline = 0;
                stanza++;
            }
            
        } // end of while loop
        return poem;
    }
    /*
     *  @param: No parameters
     *  @return: returns a phoneme string 
     *  
     *  Finds a random phoneme
     *  from the words in wordList
     */
	   String rndPhone(){
           int N = Poet.wordList.length;
           int i = (int)(N * Math.random());
           String[] phonemes = null;
           while(phonemes == null){
               phonemes = Poet.wordList[i].phonemes;	
               i = (int)(N * Math.random());
           }
           return phonemes[0];
       }
}
