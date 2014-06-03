package edu.hpi.semweb.lod.crawl.imdb.impl;

import edu.hpi.semweb.lod.crawl.imdb.IMDBGenericPersonParser;
import edu.hpi.semweb.lod.crawl.imdb.IMDBRDFBuilder;

public class EditorsParser extends IMDBGenericPersonParser{

	public EditorsParser(boolean isPatchedFile) {
		super(isPatchedFile);
	}

	@Override
	protected String defineFileName() {
		return "editors.list";
	}

	@Override
	protected String defineRelevanceStartingLine() {
		return "----                    ------";
	}

	@Override
	protected String defineRelevanceEndingLine() {
		return "-----------------------------------------------------------------------------";
	}

	@Override
	protected String definePersonRDFProperty() {
		return IMDBRDFBuilder.editor();
	}
}
