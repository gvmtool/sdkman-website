layout 'layouts/main.groovy', true,
        pageTitle: 'Installation - SDKMAN!',
        mainContent: contents {
            div(id: 'content', class: 'page-1') {
                div(class: 'row') {
                    div(class: 'row-fluid') {
                        div(class: 'col-lg-3') {}
                        div(class: 'col-lg-8 col-lg-pull-0') {
                            h1 {
                                i(class: 'fa fa-cloud-download') {}
                                yield ' Installation'
                            }
                            article {
                                p {
                                    yield '''Installing SDKMAN! on UNIX-like platforms is as easy as ever.
                                             SDKMAN! installs smoothly on Mac OSX, Linux, Cygwin,
                                             Solaris and FreeBSD. We also support Bash and ZSH shells.'''
                                    br()
                                    yield 'Simply open a new terminal and enter: '
                                }
                                pre { code '$ curl -s "https://get.sdkman.io" | bash' }
                                p {
                                    yield 'Follow the instructions on-screen to complete installation.'
                                    br()
                                    yield 'Next, open a new terminal '
                                    b 'or'
                                    yield ' enter:'
                                }
                                pre { code '$ source "$HOME/.sdkman/bin/sdkman-init.sh"' }
                                p 'Lastly, run the following code snippet to ensure that installation succeeded:'
                                pre { code '$ sdk version' }
                                p 'If all went well, the version should be displayed. Something like:'
                                pre { code '  sdkman 5.0.0+51' }
                            }

                            article {
                                h3 { yield 'Beta Channel' }

                                p {
                                    yield '''For the more adventurous among us, we have a beta channel.
                                         All new CLI features will first be rolled out to this group of users for trial purposes.
                                         Beta versions can be considered stable for the most part, but might occasionally break.
                                         To join the beta program, simply update the the '''
                                    code '~/.sdkman/etc/config'
                                    yield ' file as follows:'
                                    pre { code 'sdkman_beta_channel=true' }
                                    yield 'Next, open a new terminal and perform a forced update with:'
                                    pre { code '$ sdk selfupdate force' }
                                    yield 'To leave the beta channel, simply set the above config back to '
                                    code 'false'
                                    yield ' and follow the same procedure.'
                                }
                            }

                            article {
                                h3 { yield 'Uninstallation' }
                                yield '''In the unlikely event that you would like to uninstall SDKMAN!, we don\'t have
                                         an automated way of doing this yet. If you really do want to remove it from your
                                         system, it is very easy to do so.'''
                                yield 'The following will guide you through backing up, then removing the entire installation from your system.'
                                pre {
                                    code '''
tar zcvf ~/sdkman-backup_$(date +%F-%kh%M).tar.gz -C ~/ .sdkman
$ rm -rf ~/.sdkman'''
                                }
                                yield 'The last step involves editing and removing the initialisation snippet from your '
                                code '.bashrc'
                                yield ', '
                                code '.bash_profile'
                                yield ' and/or '
                                code '.profile'
                                yield ' files. If you use ZSH, remove it from the '
                                code '.zshrc'
                                yield ' file. The snippet of code to be removed looks something like this:'
                                pre {
                                    code '''
#THIS MUST BE AT THE END OF THE FILE FOR SDKMAN TO WORK!!!
[[ -s "/home/dudette/.sdkman/bin/sdkman-init.sh" ]] && source "/home/dudette/.sdkman/bin/sdkman-init.sh"'''
                                }
                                yield 'Once removed, you have successfully uninstalled SDKMAN! from your machine.'
                            }

                            article {
                                h3 { yield 'Installing to a Custom Location' }

                                yield 'It is possible to install SDKMAN! to a custom location other than '
                                code '$HOME/.sdkman'
                                yield '. This can be achieved by exporting your custom location as '
                                code 'SDKMAN_DIR'
                                yield ' prior to installing.'
                                br()
                                yield 'Simply open a new terminal and enter:'
                                pre { code '$ export SDKMAN_DIR="/usr/local/sdkman" && curl -s "https://get.sdkman.io" | bash' }
                                yield 'For this to work it is vital that your user has full access rights to this folder.'
                                yield 'It is also important that the folder does not exist as SDKMAN! will attempt to create it.'
                            }

                            p {
                                yield 'That\'s all there is to it! Next we will look at '
                                a(href: "/usage.html", 'Usage')
                                yield '.'
                            }
                        }
                    }
                }
            }
        }
