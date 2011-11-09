#!/bin/sh
svn co https://caliph-emir.svn.sourceforge.net/svnroot/caliph-emir/lire -r 69
svn co https://caliph-emir.svn.sourceforge.net/svnroot/caliph-emir/caliphemir/src -r 30 caliphemir-src
ant -f build-lire.xml install
