var app = new Vue({
  el: "#app",
  data: {
    countries: [
      {
        id: 1,
        currency: "Russian ruble",
        symbol: "&#8381;",
        name: "Russia",
        country_code: "+7",
        iso_code: "ru",
      },
      {
        id: 2,
        currency: "United States Dollar",
        symbol: "$",
        name: "United States Of America",
        country_code: "+1",
        iso_code: "us",
      },
      {
        id: 3,
        currency: "Canadian Dollar",
        symbol: "$",
        name: "Canada",
        country_code: "+1",
        iso_code: "ca",
      },
      {
        id: 4,
        currency: "Japanese Yen",
        symbol: "¥",
        name: "Japan",
        country_code: "+81",
        iso_code: "jp",
      },
    ],
    id: 0,
    currency: "",
    symbol: "",
    name: "",
    country_code: "",
    iso_code: "",
  },
});
