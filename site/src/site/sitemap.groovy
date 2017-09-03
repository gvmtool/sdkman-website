menu {
    group('sdkman') {
        item 'Install',                     'install.html'
        item 'SDKs',                        'sdks.html'
        item 'Usage',                       'usage.html'
//        item 'API',                         'api.html'
        item 'Vendors',                     'vendors.html'
    }

    group('Socialize') {
        item 'Discuss on Gitter',           'https://gitter.im/sdkman/user-issues',             'fa-envelope'
        item 'SDKMAN! on Twitter',           'https://twitter.com/sdkman_',                   'fa-twitter'
        item 'Source code on GitHub',       'https://github.com/sdkman',                        'fa-github'
        item 'Report issues on GitHub',     'https://github.com/sdkman/sdkman-cli/issues',      'fa-bug'
        item 'Stack Overflow questions',    'http://stackoverflow.com/questions/tagged/sdkman', 'fa-stack-overflow'
        item 'StatusPage.io',               'http://status.sdkman.io',                          ''
    }
}

pages {
    page 'index', 'index'
    page 'install', 'install'
    page 'sdks', 'sdks'
    page 'usage', 'usage'
//    page 'api', 'api'
    page 'vendors', 'vendors'
    page '404','404', [:]
}
