article {
    a(name: 'upgrade'){}
    h2 { yield 'Upgrade Version(s)' }
    p {
        yield 'To see what is currently out of date for a Candidate on your system:'
        pre { code '''
$ sdk upgrade springboot
  Upgrade:
  springboot (1.2.4.RELEASE, 1.2.3.RELEASE < 1.2.5.RELEASE)
'''     }
        yield 'To see what is outdated for '
        strong 'all'
        yield ' Candidates:'
        pre { code '''
$ sdk upgrade
  Upgrade:
  gradle (2.3, 1.11, 2.4, 2.5 < 2.6)
  grails (2.5.1 < 3.0.4)
  springboot (1.2.4.RELEASE, 1.2.3.RELEASE < 1.2.5.RELEASE)
'''     }
    }
}
br()
