article {
    a(name: 'config'){}
    h2 { yield 'Configuration' }
    p {
        yield 'Although configuration is limited, the list of configurable items will grow as required. Configuration can be found in the '
        code '~/.sdkman/etc/config'
        yield ' file. Currently the following is configurable:'
        pre { code '''
# make sdkman non-interactive, preferred for CI environments
sdkman_auto_answer=true|false

# perform automatic selfupdates
sdkman_auto_selfupdate=true|false

# disables SSL certificate verification
# https://github.com/sdkman/sdkman-cli/issues/327
# HERE BE DRAGONS....
sdkman_insecure_ssl=true|false

# configure curl timeouts
sdkman_curl_connect_timeout=5
sdkman_curl_max_time=4

# subscribe to the beta channel
sdkman_beta_channel=true
'''
        }
    }
}
br()
