new Swiper('#swiper-organization', {
  loop: true,
  slidesPerView: 1,
  spaceBetween: 16,
  breakpointsBase: 'container',
  breakpoints: {
    696: {
      slidesPerView: 2
    },
    936: {
      slidesPerView: 3
    },
    1296: {
      slidesPerView: 4
    }
  },
  navigation: {
    nextEl: '#swiper-next-organization',
    prevEl: '#swiper-prev-organization',
  }
});

new Swiper('#swiper-individual', {
  loop: true,
  slidesPerView: 1,
  spaceBetween: 16,
  breakpointsBase: 'container',
  breakpoints: {
    516: {
      slidesPerView: 2
    },
    696: {
      slidesPerView: 3
    },
    936: {
      slidesPerView: 4
    },
    1296: {
      slidesPerView: 6
    }
  },
  navigation: {
    nextEl: '#swiper-next-individual',
    prevEl: '#swiper-prev-individual',
  }
});
