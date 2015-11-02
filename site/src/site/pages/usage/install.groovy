article {
    h2 { yield 'Installing an SDK'}
    a(name: 'installdefault'){}
    h4 { yield 'Latest Stable' }
    p {
        yield 'Install the '
        strong 'latest stable'
        yield ' version of your SDK of choice (say, Gradle) by running the following command:'
        pre { code '$ sdk install gradle' }
        yield 'You will see the following output:'
        pre {
            code '''
Downloading: gradle 2.6

  % Total    % Received % Xferd  Average Speed   Time    Time     Time  Current
                                 Dload  Upload   Total   Spent    Left  Speed
100 39.0M  100 39.0M    0     0   945k      0  0:00:42  0:00:42 --:--:--  978k

Installing: gradle 2.6
Done installing!
'''
        }
        yield 'Now you will be prompted if you want this version to be set as '
        strong 'default.'
        pre { code 'Do you want gradle 2.5 to be set as default? (Y/n):' }
        yield 'Answering '
        em 'yes'
        yield ' (or '
        em 'hitting enter'
        yield ') will ensure that all subsequent shells opened will have this version of the SDK in use by default.'
        pre { code 'Setting gradle 2.5 as default.' }
    }

    a(name: 'installspecific'){}
    h4 { yield 'Specific Version' }
    p {
        yield 'Need a '
        strong 'specific'
        yield ' version of an SDK? Simply qualify the version you require:'
        pre { code '$ sdk install groovy 2.4.5'  }
        yield 'All subsequent steps same as above.'
    }
}
br()
