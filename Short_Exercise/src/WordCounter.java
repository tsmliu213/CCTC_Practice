import java.awt.List;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;


public class WordCounter {

	public static void main(String[] args) {
		String str = "From the moment the first immigrants arrived on these shores, generations of parents have worked hard and sacrificed whatever is necessary so that their children could have the same chances they had; or the chances they never had. Because while we could never ensure that our children would be rich or successful; while we could never be positive that they would do better than their parents, America is about making it possible to give them the chance. To give every child the opportunity to try. Education is still the foundation of this opportunity. And the most basic building block that holds that foundation together is still reading. At the dawn of the 21st century, in a world where knowledge truly is power and literacy is the skill that unlocks the gates of opportunity and success, we all have a responsibility as parents and librarians, educators and citizens, to instill in our children a love of reading so that we can give them the chance to fulfill their dreams.";
		Scanner sc = new Scanner(str);
		
		Map<String, Integer> wordCounts = new HashMap<String, Integer>();
		while(sc.hasNext()) {
			String word = sc.next().toLowerCase().replaceAll("[^a-zA-Z0-9]","");
			if(!wordCounts.containsKey(word)) {
				wordCounts.put(word, 1);
			}
			else {
				int count = wordCounts.get(word);
				wordCounts.put(word, count+1);
			}
		}
		printOrder(wordCounts);
		sc.close();
	}
	
	public static void printOrder(Map<String, Integer> wordCounts) {
		ArrayList<String> words = new ArrayList<String>(wordCounts.keySet());
		Collections.sort(words);
		Collections.sort(words, new Comparator<String>() {
			@Override
			public int compare(String word1, String word2) {
				return Integer.compare(wordCounts.get(word1), wordCounts.get(word2));
			}
		}.reversed());
		for(String word: words) {
			int count = wordCounts.get(word);
			System.out.printf("%-20s %d\n", word, count);
		}
	}
}
