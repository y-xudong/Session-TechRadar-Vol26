import {expect} from "@esm-bundle/chai";
import {sum} from "../src/sum.js"

it('sums up 2 numbers', () => {
    expect(sum(1, 2)).to.equal(3);
    expect(sum(10, 3)).to.equal(13);
})
