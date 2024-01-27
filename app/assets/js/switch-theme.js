(() => {
  'use strict'

  const THEME_STORAGE_NAME = 'theme';
  const getStoredTheme = () => localStorage.getItem(THEME_STORAGE_NAME)
  const setStoredTheme = theme => localStorage.setItem(THEME_STORAGE_NAME, theme)

  const getPreferredTheme = () => {
    const storedTheme = getStoredTheme()

    if (storedTheme) {
      return storedTheme
    }

    return window.matchMedia('(prefers-color-scheme: dark)').matches ? 'dark' : 'light'
  }

  const setTheme = theme => {
    if (theme === 'auto' && window.matchMedia('(prefers-color-scheme: dark)').matches) {
      document.documentElement.setAttribute('data-bs-theme', 'dark')
    } else {
      document.documentElement.setAttribute('data-bs-theme', theme)
    }
  }

  setTheme(getPreferredTheme())

  const showActiveTheme = theme => {
    const activeThemeIcon = document.querySelector(`[data-bs-theme-value="${theme}"]`)

    document.querySelectorAll('[data-bs-theme-value]').forEach(element => {
      element.classList.add('d-none')
    })

    activeThemeIcon.classList.remove('d-none')
  }

  window.matchMedia('(prefers-color-scheme: dark)').addEventListener('change', () => {
    const storedTheme = getStoredTheme()

    if (storedTheme !== 'light' && storedTheme !== 'dark') {
      setTheme(getPreferredTheme())
    }
  })

  window.addEventListener('DOMContentLoaded', () => {
    const themeSwitcher = document.querySelector('#bd-theme')

    if (!themeSwitcher) {
      return
    }

    showActiveTheme(getPreferredTheme())

    themeSwitcher.addEventListener('click', () => {
      const theme = getStoredTheme() === 'light' ? 'dark' : 'light'

      setStoredTheme(theme)
      setTheme(theme)
      showActiveTheme(theme)
    })
  })
})()
