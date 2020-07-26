import axios from 'axios';

axios.defaults.headers.post["Content-Type"] = "application/json"

const config = {
  baseURL: process.env.VUE_APP_INTERNAL_API_URL,
  timeout: 5000
};

const externalConfig = {
  baseURL: process.env.VUE_APP_EXTERNAL_API_URL,
  timeout: 10000
};

const request = axios.create(config);

const externalRequest = axios.create(externalConfig);

export { request, externalRequest };