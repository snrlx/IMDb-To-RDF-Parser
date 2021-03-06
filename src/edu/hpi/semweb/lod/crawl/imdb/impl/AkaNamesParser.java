package edu.hpi.semweb.lod.crawl.imdb.impl;

import edu.hpi.semweb.lod.crawl.imdb.IMDBActor;
import edu.hpi.semweb.lod.crawl.imdb.IMDBParser;
import edu.hpi.semweb.lod.crawl.imdb.IMDBRDFBuilder;
import edu.hpi.semweb.lod.crawl.imdb.RegexHelper;

public class AkaNamesParser extends IMDBParser{
	private IMDBActor currentActor;

	public AkaNamesParser(boolean isPatchedFile) {
		super(isPatchedFile);
	}

	@Override
	public String defineFileName() {
		return "aka-names.list";
	}

	@Override
	protected void onNewLine(String line) {
		if(line.startsWith(" ")){
			IMDBActor aka = new IMDBActor(RegexHelper.findFirstOccurence(line, "aka\\s[^)]+").replace("aka ", ""));
			writeRDF(IMDBRDFBuilder.hpilodActor(currentActor.toString()), IMDBRDFBuilder.akaName(), IMDBRDFBuilder.string(aka.toString()));
		}else{
			currentActor = new IMDBActor(line);
			return;
		}
	}

	@Override
	protected String defineRelevanceStartingLine() {
		return "==============";
	}

	@Override
	protected String defineRelevanceEndingLine() {
		return null;
	}

	@Override
	protected void onFileEnd() {
		// TODO Auto-generated method stub
		
	}

}
