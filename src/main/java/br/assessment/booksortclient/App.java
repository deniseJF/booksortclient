package br.assessment.booksortclient;

import java.util.Arrays;
import java.util.List;

import net.sourceforge.argparse4j.ArgumentParsers;
import net.sourceforge.argparse4j.inf.ArgumentParser;
import net.sourceforge.argparse4j.inf.ArgumentParserException;
import net.sourceforge.argparse4j.inf.Namespace;
import br.assessment.sorting.SortingService;

public class App {
	public static void main(String[] args) {
		ArgumentParser parser = ArgumentParsers.newArgumentParser(
				"booksortclient").description(
				"Client for the booksort service.");
		parser.addArgument("jsonPath").help("Path to json config file");
        try {
            Namespace res = parser.parseArgs(args);
            runClientWithConfigFile(res.getString("jsonPath"));
        } catch (ArgumentParserException e) {
            parser.handleError(e);
        }
	}

	private static void runClientWithConfigFile(String jsonPath) {
		List<Book> bookList = createBookList();
		SortingService sortingService = new SortingService(jsonPath);
		sortingService.sortList(bookList);
		printBookList(bookList);
	}

	public static List<Book> createBookList() {
		return Arrays.asList(new Book("Java How to Program", "Deitel & Deitel",
				2007), new Book(
				"Patterns of Enterprise Application Architecture",
				"Martin Fowler", 2002), new Book("Head First Design Patterns",
				"Elisabeth Freeman", 2004), new Book(
				"Internet & World Wide Web: How to Program", "Deitel & Deitel",
				2007));
	}

	public static void printBookList(List<Book> list) {
		System.out.println("\n\n Sorting Book List:\n");
		for (Book b : list) {
			System.out.println(b);
		}
		System.out.println();
	}
}
